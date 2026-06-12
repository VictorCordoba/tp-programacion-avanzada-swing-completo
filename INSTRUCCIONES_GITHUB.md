# Instrucciones para subir el proyecto a GitHub

## 1. Crear repositorio en GitHub

Crear un repositorio nuevo, por ejemplo:

```text
programacion-avanzada-swing-completo
```

No hace falta agregar README desde GitHub, porque el proyecto ya incluye uno.

## 2. Abrir terminal en la carpeta del proyecto

Ubicarse dentro de la carpeta:

```bash
cd ProgramacionAvanzadaSwingCompleto
```

## 3. Inicializar Git

```bash
git init
git add .
git commit -m "Entrega TP Swing Completo"
```

## 4. Vincular con GitHub

Reemplazar la URL por la del repositorio propio:

```bash
git branch -M main
git remote add origin https://github.com/USUARIO/programacion-avanzada-swing-completo.git
git push -u origin main
```

## 5. Enlace para entregar

Una vez subido, copiar el enlace del repositorio y entregarlo en la actividad de la materia.

Ejemplo:

```text
https://github.com/USUARIO/programacion-avanzada-swing-completo
```
