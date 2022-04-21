use tpterroir;
insert into compte(compte_id ,compte_password, compte_username, is_admin) values (10000 ,'$2a$10$vJ18K05XeE4YVEKZhHRK7.4K.nFD7gDdH10q/JMlLihZEjVQnW8ES', 'admin', 1);
insert into personne(personne_nom, compte_idref) values('admin', 10000);