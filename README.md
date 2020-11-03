# Persistencia de dados

This repository has the works done in the discipline of Data Persistence, belonging to the semester 2019.2. The jobs are cruds using JSON and XML files, as well as the Cassandra and Hibernate database.

# Eclipse IDE installation

![Eclipse IDE](https://fernandofranzini.files.wordpress.com/2018/05/maxresdefault.jpg?w=400)

* Step 1. Open a terminal;
* Step 2. If you have already done a manual installation of the program, use the commands below to delete it;
```bash
rm -Rf /opt/eclipse/
```

```bash
rm -Rf /usr/share/applications/eclipse.desktop
```
* Step 3. Check if your system is 32-bit or 64-bit, to do this, use the following command in the terminal:
```bash
uname -m
```
* Step 4. If your system is 32-bit, use the command below. If the link is out of date, access this page, download the latest version and save the file with the name eclipse.tar.gz;
```bash
wget -c http://eclipse.c3sl.ufpr.br/technology/epp/downloads/release/photon/R/eclipse-jee-photon-R-linux-gtk.tar.gz -O eclipse.tar.gz
```

* Step 5. If your system is 64-bit, use the command below. If the link is out of date, access this page, download the latest version and save the file with the name eclipse.tar.gz;
```bash
wget -c http://eclipse.c3sl.ufpr.br/technology/epp/downloads/release/photon/R/eclipse-jee-photon-R-linux-gtk-x86_64.tar.gz -O eclipse.tar.gz
```

* Step 9. If your current graphic environment supports it, create a launcher for the program, executing the command below;
```bash
echo -e '[Desktop Entry]\n Version=1.0\n Name=eclipse\n Exec=/opt/eclipse/eclipse\n Icon=/opt/eclipse/eclipse.png\n Type=Application\n Categories=Application' | sudo tee /usr/share/applications/eclipse.desktop
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)

