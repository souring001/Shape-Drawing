JAVA=java $(JAVAFLAGS)
JAVAC=javac $(JAVACFLAGS)
JAVADOC=javadoc $(JAVADOCFLAGS)
OUTPUTFILTER=2>&1 | nkf
#OUTPUTFILTER=2>&1 | nkf -w8
FIND=find
MKDIR=mkdir -p 
RM=rm -rf
CLASSPATH=lib/commons-codec-1.10.jar
JAVACFLAGS= -encoding utf-8 -d bin -sourcepath src -cp bin:$(CLASSPATH) -Xlint:deprecation
JAVAFLAGS = -cp bin:$(CLASSPATH)
JAVADOCFLAGS= -encoding UTF-8 -charset utf-8 -d javadoc -sourcepath src -J-Dhttp.proxyHost=proxy.csc.titech.ac.jp -J-Dhttp.proxyPort=8080 -link http://docs.oracle.com/javase/jp/8/docs/api -classpath $(CLASSPATH)
#In case that you can access without proxy
#JAVADOCFLAGS= -encoding utf-8 -charset utf-8 -d javadoc -sourcepath src -link http://docs.oracle.com/javase/jp/8/docs/api -classpath $(CLASSPATH)

.PHONY: clean javadoc

.SUFFIXES: .class .java

.java.class: $(<:.class=.java)
	$(MKDIR) bin
	$(JAVAC) $< $(OUTPUTFILTER)

.class:
	$(JAVA) $(<:.class=)

Main0: 
	$(MKDIR) bin
	$(JAVAC) src/pro3/$@.java $(OUTPUTFILTER)
	$(JAVA) pro3.$@ $(OUTPUTFILTER)

Main1:
	$(MKDIR) bin
	$(JAVAC) src/pro3/$@.java $(OUTPUTFILTER)
	$(JAVA) pro3.$@ $(OUTPUTFILTER)

Main2:
	$(MKDIR) bin
	$(JAVAC) src/pro3/$@.java $(OUTPUTFILTER)
	$(JAVA) pro3.$@ $(OUTPUTFILTER)

Main3:
	$(MKDIR) bin
	$(JAVAC) src/pro3/$@.java $(OUTPUTFILTER)
	$(JAVA) pro3.$@ $(OUTPUTFILTER)

Main4:
	$(MKDIR) bin
	$(JAVAC) src/pro3/$@.java $(OUTPUTFILTER)
	$(JAVA) pro3.$@ $(OUTPUTFILTER)

clean:	
	$(RM) bin movie.avi moviec.avi tout.txt

javadoc::
	$(FIND) . -name "._*" -exec $(RM) {} \;
	$(MKDIR) javadoc
	$(JAVADOC) -d javadoc pro3 pro3.shape pro3.target pro3.parser $(OUTPUTFILTER)
