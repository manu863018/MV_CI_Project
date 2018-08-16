echo 'Stopping Tomcat service...'		
sudo systemctl stop tomcat8
sudo rm -f /var/lib/tomcat8/webapps/webapp-quickstart.war
sudo rm -rf /var/lib/tomcat8/webapps/webapp-quickstart

echo 'Sending war file...'
sudo cp -f /tmp/webapp-quickstart.war /var/lib/tomcat8/webapps/webapp-quickstart.war
sudo rm /tmp/webapp-quickstart.war

echo 'Starting Tomcat service...'
sudo systemctl start tomcat8

