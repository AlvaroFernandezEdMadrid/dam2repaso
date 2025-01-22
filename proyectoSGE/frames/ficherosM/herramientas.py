import tkinter as tk

class coloresAplicacion():
    def __init__(self):
        self.Color_Cabecera_Pie = "#a5049E"
        self.Color_Principal = "#D805CD"
        self.Color_Izquierda = "#B805AF"
        self.Color_Fuente_Secundario = "#7A0374"
        self.Color_Fuente = "#790262"

    def get_Color_Cabecera(self):
        return self.Color_Cabecera_Pie
    
    def get_Color_Principal(self):
        return self.Color_Principal
    
    def get_Color_Izquierda(self):
        return self.Color_Izquierda
    
    def get_Color_Fuente_Secundario(self):
        return self.Color_Fuente_Secundario
    
    def get_Color_Fuente(self):
        return self.Color_Fuente
    
class miTexto():
    def __init__(self, seccion, texto, fuente, tamanno, posicion, color):
        self.seccion = seccion
        self.texto = texto
        self.fuente = fuente
        self.tamanno = tamanno
        self.posicion = posicion
        self.color = color
        self.textLoad()

    def textLoad(self):
        self.sec = tk.Label(self.seccion, text=self.texto)
        self.colores = coloresAplicacion()
        self.sec.config(fg=self.color, font=(self.fuente, self.tamanno), bg=self.colores.get_Color_Cabecera(), padx=10, pady=10)
        self.sec.pack(side=self.posicion)

