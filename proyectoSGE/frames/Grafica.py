import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg

class Grafica:
    def __init__(self, master_frame):
        # Guardar frame donde se muestra el plot
        self.master_frame = master_frame
        self.canvas = None  # Iniciar canvas

    def mostrar_grafica(self):
        # Eliminar graficas anteriores
        for widget in self.master_frame.winfo_children():
            widget.destroy()

        # Crear plot
        fig, ax = plt.subplots(figsize=(5, 4))
        ax.plot([1.2, 2.3, 3.4, 4.5, 5.6], [2.3, 4.5, 6.7, 8.9, 10.11], label="Ejemplito")
        ax.set_title("Grafico")
        ax.set_xlabel("Eje X")
        ax.set_ylabel("Eje Y")
        ax.legend()

        # Insertar plot en frame
        self.canvas = FigureCanvasTkAgg(fig, master=self.master_frame)
        self.canvas.draw()
        self.canvas.get_tk_widget().pack(fill="both", expand=True)
