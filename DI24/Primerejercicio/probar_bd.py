from baseDatos import BaseDatos

def main():
    bd = BaseDatos()
    print("Probando conexión y cargando cargos...")
    try:
        cargos = bd.obtener_cargos()
        print("Cargos obtenidos:", cargos)
    except Exception as e:
        print("Error al consultar la base de datos:", e)

    print("Probando login de prueba...")
    resultado = bd.comprobar_login("Javier", "1234")
    print("Resultado login:", resultado)

if __name__ == "__main__":
    main()