import pymysql

class ConexionBaseDatos:
    def conectar(self):
        try:
            conexion = pymysql.connect(
                host="localhost",
                user="root",
                password="",  # tu contraseña de XAMPP
                database="uem",
                charset='utf8mb4',
                cursorclass=pymysql.cursors.DictCursor
            )
            print("Conexión PyMySQL establecida")
            return conexion
        except Exception as e:
            print("Error conectando a MySQL con PyMySQL:", e)
            return None