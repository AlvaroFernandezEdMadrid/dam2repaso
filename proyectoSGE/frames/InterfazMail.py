import tkinter as tk
from Email1 import MandarEmail

class InterfazMail:
    def __init__(self, frame):
        self.frame = frame
        
    def mostrarFormulario(self):
        # Limpiar contenido del frame
        for widget in self.frame.winfo_children():
            widget.destroy()

        # Establecer color de fondo
        self.frame.config(bg="#DAB0CC")

        # Establecer tamaño de fuente
        font = ('Arial', 13)
        font_bold = ('Arial', 13, 'bold')  # Fuente en negrita para las etiquetas

        # Etiquetas y entradas con pack
        tk.Label(self.frame, text="Usuario:", font=font_bold, bg="#DAB0CC").pack(padx=10, pady=5, anchor="w")
        entry_username = tk.Entry(self.frame, font=font)
        entry_username.pack(fill="x", padx=10, pady=5)

        tk.Label(self.frame, text="Contraseña:", font=font_bold, bg="#DAB0CC").pack(padx=10, pady=5, anchor="w")
        entry_password = tk.Entry(self.frame, show="*", font=font)
        entry_password.pack(fill="x", padx=10, pady=5)

        tk.Label(self.frame, text="Correo destinatario:", font=font_bold, bg="#DAB0CC").pack(padx=10, pady=5, anchor="w")
        entry_to_email = tk.Entry(self.frame, font=font)
        entry_to_email.pack(fill="x", padx=10, pady=5)

        tk.Label(self.frame, text="Asunto:", font=font_bold, bg="#DAB0CC").pack(padx=10, pady=5, anchor="w")
        entry_subject = tk.Entry(self.frame, font=font)
        entry_subject.pack(fill="x", padx=10, pady=5)

        tk.Label(self.frame, text="Cuerpo del correo:", font=font_bold, bg="#DAB0CC").pack(padx=10, pady=5, anchor="w")
        entry_body = tk.Text(self.frame, font=font, height=10, width=40)
        entry_body.pack(padx=10, pady=5)

        # Función para enviar el correo
        def enviar_email():
            username = entry_username.get()
            password = entry_password.get()
            from_email = f"{username}@educa.madrid.org"
            to_email = entry_to_email.get()
            subject = entry_subject.get()
            body = entry_body.get("1.0", tk.END).strip()  # Obtener el texto del cuerpo

            email_sender = MandarEmail(username, password)
            email_sender.enviar(subject, body, from_email, to_email)
            email_sender.disconnect()

        # Botón de envío
        btn_enviar = tk.Button(self.frame, text="Enviar Correo", command=enviar_email, font=font)
        btn_enviar.pack(pady=10)
