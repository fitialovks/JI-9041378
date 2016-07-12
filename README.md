
Sample project for Java compiler bug JI-9041378.
This bug is reproduced on my Ubuntu 16.04 laptop with javac 1.8.0_92
every time I run the build.

This projects has two annotation processors in the classpath:

1. org.openjdk.jmh.generators.BenchmarkProcessor
2. org.apache.logging.log4j.core.config.plugins.processor.PluginProcessor

Both are registered via `META-INF/services/javax.annotation.processing.Processor`
in their jars. Only one of them is applied without explicit `-processor` option for compiler.

Instructions:

Run `./gradlew clean build`
You will notice failing assertion which indicates that one of annotation 
processors did now work.

Go to `build.gradle` and uncomment the hack with `javac -processor`
argument to make the build work and have a look at expected results. 