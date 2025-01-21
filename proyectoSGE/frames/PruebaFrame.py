import tkinter as tk

# Crear la ventana principal
ventana = tk.Tk()
ventana.title("4 Frames en las Esquinas")

# Crear los frames
frame_norte_izq = tk.Frame(ventana, width=100, height=100, bg="lightblue")
frame_norte_izq.grid(row=0, column=0, padx=10, pady=10)

frame_norte_der = tk.Frame(ventana, width=100, height=100, bg="lightgreen")
frame_norte_der.grid(row=0, column=1, padx=10, pady=10)

frame_sur_izq = tk.Frame(ventana, width=100, height=100, bg="lightcoral")
frame_sur_izq.grid(row=1, column=0, padx=10, pady=10)

frame_sur_der = tk.Frame(ventana, width=100, height=100, bg="lightyellow")
frame_sur_der.grid(row=1, column=1, padx=10, pady=10)

# Agregar botones y etiquetas a cada frame
# Frame superior izquierdo
boton_1 = tk.Button(frame_norte_izq, text="Botón 1")
boton_1.pack(pady=5)
etiqueta_1 = tk.Label(frame_norte_izq, text="Etiqueta 1")
etiqueta_1.pack()

# Frame superior derecho
boton_2 = tk.Button(frame_norte_der, text="Botón 2")
boton_2.pack(pady=5)
etiqueta_2 = tk.Label(frame_norte_der, text="Etiqueta 2")
etiqueta_2.pack()

# Frame inferior izquierdo
boton_3 = tk.Button(frame_sur_izq, text="Botón 3")
boton_3.pack(pady=5)
etiqueta_3 = tk.Label(frame_sur_izq, text="Etiqueta 3")
etiqueta_3.pack()

# Frame inferior derecho
boton_4 = tk.Button(frame_sur_der, text="Botón 4")
boton_4.pack(pady=5)
etiqueta_4 = tk.Label(frame_sur_der, text="Etiqueta 4")
etiqueta_4.pack()

# Ejecutar el bucle principal
ventana.mainloop()
