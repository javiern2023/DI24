# baseDatos.py
from conexionBaseDatos import ConexionBaseDatos

class BaseDatos:
    def __init__(self):
        self.conexionBD = ConexionBaseDatos() #Objeto de la clase base de datos para la conexión, se prepara el acceso

    def comprobar_login(self, usuario, contrasenia):
        conexion = self.conexionBD.conectar() #conexión a la base de datos
        if conexion is None: #si no devuelve el objeto conexion salta la excepción
            raise Exception("No se pudo conectar a la base de datos")

        try:
            cursor = conexion.cursor() #El cursor es el objeto que permite ejecutar consultas a la base de datos
            sql = "SELECT * FROM alumno WHERE nombre=%s AND contrasenia=%s" #Consulta sql. Se usa % para evitar inyección SQL (vulnerabilidades)
            cursor.execute(sql, (usuario, contrasenia)) #Ejecución de la sentencia con los valores
            resultado = cursor.fetchone()  # devuelve tupla o None si es vacío. Solo una fila, si hay más se queda sólo la primera
            cursor.close()
            conexion.close()
            return resultado
        except Exception as e:
            print("Error en consulta login:", e)
            try:
                cursor.close()
                conexion.close()
            except:
                pass #Excepciones genéricas, la que sea.
            return None

    def obtener_cargos(self):
        """Devuelve una lista de cargos desde la tabla 'cargo'"""
        conexion = self.conexionBD.conectar()
        if conexion is None:
            print("No se pudo conectar a la base de datos para obtener cargos")
            return []

        try:
            cursor = conexion.cursor()
            sql = "SELECT nombre FROM cargo"
            cursor.execute(sql)
            resultados = cursor.fetchall()  # [{'nombre': 'Profesor'}, {'nombre': 'Alumno'}] Lista con todos los registros

            cursor.close()
            conexion.close()

            return resultados  # devolvemos los diccionarios directamente

        except Exception as e:
            print("Error en consulta obtener_cargos:", e)
            try:
                cursor.close()
                conexion.close()
            except:
                pass
            return []

    def insertar_usuario(self, nombre, contrasenia, ciclo):

        conexion = self.conexionBD.conectar()
        if conexion is None:
            raise Exception("No se pudo conectar a la base de datos")

        try:
            cursor = conexion.cursor()

            sql = """INSERT INTO usuario (nombre, contrasenia, ciclo) VALUES (%s, %s, %s)"""

            cursor.execute(sql, (nombre, contrasenia, ciclo))

            conexion.commit() #guarda definitivamente los datos en la base de datos.

            cursor.close()
            conexion.close()

            return True

        except Exception as e:
            print("Error insertando usuario:", e)
            try:
                conexion.rollback() #se cancelan los cambios y vuelve a un estado anterior. Evita datos corruptos.
                cursor.close()
                conexion.close()
            except:
                pass
            return False

    def obtener_usuarios(self):

        conexion = self.conexionBD.conectar()

        try:
            cursor = conexion.cursor()

            sql = "SELECT id, nombre, contrasenia, ciclo FROM usuario"
            cursor.execute(sql)

            resultados = cursor.fetchall()

            cursor.close()
            conexion.close()

            return resultados

        except Exception as e:
            print("Error obteniendo usuarios:", e)
            return []
