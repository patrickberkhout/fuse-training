	
# Import the PEM certificates in a truststore. 

	keytool -noprompt -import -v -trustcacerts \
	-alias YOUR_SERVER -file YOUR_SERVER.cer \
	-keystore sslclient-truststore.jks \
	-keypass YOUR_KEY_PASS -storepass welkom
