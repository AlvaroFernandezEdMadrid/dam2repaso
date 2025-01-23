import tkinter as tk
from herramientas import coloresAplicacion, miTexto
from tkinter import PhotoImage


class ventanaPrincipal(tk.Tk):
    def __init__(self, width, height, x, y, title):
        super().__init__()
        self.width = width
        self.height = height
        self.x = x
        self.y = y
        self.miTitulo = title
        cA = coloresAplicacion()
        self.Color_principal = cA.get_Color_Principal()
        self.Color_izquierda = cA.get_Color_Izquierda()
        self.Color_Cabecera = cA.get_Color_Cabecera()
        self.Color_Fuente = cA.get_Color_Fuente()
        self.Color_Fuente_Secundaria = cA.get_Color_Fuente_Secundario()
        self.geometry(f"{self.width}x{self.height}+{self.x}+{self.y}")
        self.title(self.miTitulo)
        self.resizable(False, False)

    def Cajas(self):
        self.cabecera = tk.Frame(
            self,
            bg=self.Color_Cabecera,
            height=40,
        )
        self.cabecera.pack(side=tk.TOP, fill="both")

        self.pie = tk.Frame(
            self,
            bg=self.Color_Cabecera,
            height=40,
        )
        self.pie.pack(side=tk.BOTTOM, fill="both")

        self.izquierda = tk.Frame(
            self,
            bg=self.Color_izquierda,
            width=150,
        )
        self.izquierda.pack(side=tk.LEFT, fill="both", expand=False)

        self.principal = tk.Frame(
            self,
            bg=self.Color_principal
        )
        self.principal.pack(side=tk.RIGHT, fill="both", expand=True)

        miTexto(self.cabecera, '2º de CFGS DAM', 'Arial', 20, tk.TOP, self.Color_Fuente)
        miTexto(self.pie, 'Enero de 2025', 'Arial', 20, tk.LEFT, self.Color_Fuente_Secundaria)

        self.sec = tk.Label(self.principal, text='Villablanca \n E.R.P.')
        self.sec.config(fg=self.Color_Fuente, font=('Arial', 60), bg=self.Color_principal, padx=10, pady=10)
        self.sec.pack(pady=150)

        # Verifica si la imagen existe antes de cargarla
        try:
            self.logo = PhotoImage(file='package/Logo.jpg')
            tk.Label(self.izquierda, image=self.logo, bg=self.Color_izquierda).pack(side=tk.TOP, pady=10, padx=10)
        except tk.TclError:
            print("No se pudo cargar la imagen. Verifica la ruta del archivo.")

        self.btnOpcion1 = tk.Button(self.izquierda)

        Buttons_Options = [
            
        ]

        for texto, boton, comando in Buttons_Options:
            self.configurar_boton_menu(boton, texto, comando)

    def configurar_boton_menu(self, boton, texto, comando):
        boton.config(text=f"{texto}", anchor="w", font=("Arial", 15), bd=0, bg="#6B3799", fg=self.Color_izquierda, width=20, height=1, command=comando)
        boton.pack(side=tk.TOP, pady=10)

# Si estás ejecutando este script, puedes inicializar la ventana principal así:
if __name__ == "__main__":
    app = ventanaPrincipal(800, 600, 100, 100, "Mi Aplicación")
    app.Cajas()
    app.mainloop()
