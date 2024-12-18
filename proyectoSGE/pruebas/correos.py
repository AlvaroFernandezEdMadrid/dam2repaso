import smtplib
from email.message import EmailMessage

men = EmailMessage()

mensaje_cuerpo = "Prueba DAM2"
usuario = "alvaro.fernandez223"
mensaje_origen = f"{usuario}@educa.madrid.org"  
mensaje_destino = "alvaro.fernandez223@educa.madrid.org"  

cliente_smtp = "smtp01.educa.madrid.org"

men['Subject'] = "Probando..."
men['From'] = mensaje_origen
men['To'] = mensaje_destino

men.set_content(mensaje_cuerpo)

server = smtplib.SMTP(cliente_smtp, 587)

server.ehlo()
server.starttls()  

server.login(usuario, "contrasenia")

server.send_message(men)

server.quit()
