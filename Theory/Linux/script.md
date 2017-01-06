 #!/bin/bash
 tar -czvf /home/cvs_backup/cvs_bak_$(date '+%Y%m%d').tar.gz /home/cvs
 chmod -R 770 /home/cvs_backup
 chown -R cpwas:cpwas /home/cvs_backup
 find /home/cvs_backup -mtime +7 -exec rm -f {} \;