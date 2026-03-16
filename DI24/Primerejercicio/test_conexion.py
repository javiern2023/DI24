import mysql.connector
from mysql.connector import Error

try:
    print("Intentando conectar a MySQL...")
    conexion = mysql.connector.connect(
        host="localhost",
        user="root",
        password="",   # tu password de XAMPP, normalmente vacío
        database="uem"
    )
    print("Conexión establecida correctamente")

    # Probar consulta simple
    cursor = conexion.cursor()
    cursor.execute("SELECT * FROM alumno")
    resultados = cursor.fetchall()
    print("Datos de la tabla alumno:", resultados)

    conexion.close()
    print("Conexión cerrada correctamente")
except Error as e:
    print("Error conectando a MySQL:", e)
except Exception as e:
    print("Error inesperado:", e)