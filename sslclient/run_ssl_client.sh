java \
-Djavax.net.ssl.trustStoreType=jks \
-Djavax.net.ssl.trustStore=truststore.jks \
-Djavax.net.debug=ssl  \
-Djavax.net.ssl.trustStorePassword=welkom \
-jar target/sslclient-1.0.0-SNAPSHOT.jar \
https://localhost:10003/proxy


