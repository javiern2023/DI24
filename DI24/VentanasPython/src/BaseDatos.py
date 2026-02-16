'''
Created on 3 mar 2025

@author: javi

1.- Instalación de la librería MySql Connector
    pip install mysql-connector-python

2.- Conexión con la base de datos
    import mysql.connector

    # Conectar con la base de datos
    conexion = mysql.connector.connect(
        host="localhost",      # Servidor (para XAMPP es localhost)
        user="root",           # Usuario (por defecto en XAMPP es root)
        password="",           # Contraseña (en XAMPP por defecto es vacía)
        database="nombreBaseDatos"     # Nombre de la base de datos
    )
    
    if conexion.is_connected():
        print("✅ Conexión exitosa a la base de datos")
    conexion.close()

3.- Crear una tabla desde Pyhton
    cursor = conexion.cursor()
    cursor.execute("""
        CREATE TABLE IF NOT EXISTS usuarios (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nombre VARCHAR(50),
            edad INT
        )
    """)
    print("✅ Tabla creada correctamente")
    conexion.close()

4.- Insertar datos 
    conexion = mysql.connector.connect(host="localhost", user="root", password="", database="mi_base")
    cursor = conexion.cursor()
    
    sql = "INSERT INTO usuarios (nombre, edad) VALUES (%s, %s)"
    valores = ("Juan", 30)
    
    cursor.execute(sql, valores)
    conexion.commit()  # Guardar cambios
    
    print(f"✅ Registro insertado con ID {cursor.lastrowid}")
    conexion.close()

5.- Consultar datos
    conexion = mysql.connector.connect(host="localhost", user="root", password="", database="mi_base")
    cursor = conexion.cursor()
    
    cursor.execute("SELECT * FROM usuarios")
    resultados = cursor.fetchall()  # Obtener todos los registros
    
    for fila in resultados:
        print(fila)  # Muestra cada fila
    
    conexion.close()
    
6.- Actualizar datos
    conexion = mysql.connector.connect(host="localhost", user="root", password="", database="mi_base")
    cursor = conexion.cursor()
    
    sql = "UPDATE usuarios SET edad = %s WHERE nombre = %s"
    valores = (35, "Juan")
    
    cursor.execute(sql, valores)
    conexion.commit()
    
    print("✅ Registro actualizado")
    conexion.close()
    
7.- Eliminar datos
    conexion = mysql.connector.connect(host="localhost", user="root", password="", database="mi_base")
    cursor = conexion.cursor()
    
    sql = "DELETE FROM usuarios WHERE nombre = %s"
    valores = ("Juan",)
    
    cursor.execute(sql, valores)
    conexion.commit()
    
    print("✅ Registro eliminado")
    conexion.close()
    


'''
