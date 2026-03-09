import sqlite3

miConexion=sqlite3.connect("Base datos")

puntero=miConexion.cursor()
#puntero.execute("CREATE TABLE USUARIOS(USER VARCHAR(50), PASS VARCHAR(20))")
puntero.execute("INSERT INTO USUARIOS VALUES('JAVIER','123')")
miConexion.commit()
miConexion.close()