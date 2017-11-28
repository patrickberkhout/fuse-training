# Build
	mvn clean:install

# Fuse features prerequisites
	features:install camel-http
	features:install camel-jetty
	features:install camel-urlrewrite
	features:install karaf
	features:install deployer

# Predeployment
Copy the `com.github.patrickberkhout.com.fuseproxy.properties` to FUSE/etc. edit accordingly
Copy the `com.github.patrickberkhout.com.fuseproxy.rewrite.xml` to FUSE/etc. edit accordingly

# Deployment
Copy the `target/fuseproxy-1.0.0-SNAPSHOT.kar` to FUSE/deploy


# SSL
## SSL - generate fuseproxy keystore with self signed certificate

	keytool -genkey \
			-alias fuseproxy \
			-keyalg RSA \
			-keypass welkom \
			-storepass welkom \
		 	-dname "CN=localhost, OU=fuseproxy, O=fuseproxy, L=fuseproxy, S=fuseproxy, C=NL" \
			-keystore fuseproxy-keystore.jks

## SSL - Export the certificate

	keytool -exportcert \
		-alias fuseproxy \
		-storepass welkom \
		-file fuseproxy.cer \
		-keystore fuseproxy-keystore.jks
		
	keytool -exportcert \
		-alias fuseproxy \
		-keypass welkom \
		-keystore fuseproxy-keystore.jks \
		-storepass welkom \
		-rfc \
		-file fuseproxy.pem

## Import the PEM certificate in a jks file
	
	keytool -noprompt -import -v -trustcacerts \
	-alias fuseproxy -file fuseproxy.cer \
	-keystore client-truststore.jks \
	-keypass welkom -storepass welkom
	
##	
	mvn clean install -f ../sslclient
	java \
	-Djavax.net.ssl.trustStoreType=jks \
	-Djavax.net.ssl.trustStore=client-truststore.jks \
	-Djavax.net.debug=ssl  \
	-Djavax.net.ssl.trustStorePassword=welkom \
	-jar ../sslclient/target/sslclient-1.0.0-SNAPSHOT.jar \
	https://localhost:10003/proxy
	