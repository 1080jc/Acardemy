# Acardemy
# Planificación proyecto de aula

## Detalles

- **FECHA:** AGOSTO - 2025
- **NOMBRE: Acardemy**
- **ESLOGAN:** *“Flashcards inteligentes para el aprendizaje de cualquier tema”*
- **PROPOSITO:** ayudar a los estudiantes a **recordar y organizar información** mediante tarjetas de estudio digitales.
- **BASADO:** Se basa en anki la cula es una plataforma de aprendisaje por medio de flashcards, pero esta seria llevada con una idea de mejor organizacion y con una interfas mas intuitiva.

---

## Objetivos del Proyecto

### **Objetivo General**

Desarrollar una aplicación web de **flashcards** que supere las limitaciones de herramientas existentes como Anki, ofreciendo una experiencia de estudio más organizada, intuitiva y efectiva.

### **Objetivos Específicos**

- **Organización de contenido** → Implementar un sistema de **categorías o mazos temáticos** para clasificar las tarjetas de estudio.
- **Interfaz intuitiva** → Diseñar una **UI moderna y fácil de usar**, que facilite la navegación y la interacción del usuario.
- **Modos de estudio** → Incorporar **dos modalidades de práctica**:
    - Revisión clásica (lectura/repaso).
    - Escritura activa (responder escribiendo).
- **Algoritmo de repetición espaciada** → Implementar un sistema de repaso basado en la memoria a largo plazo, optimizando los intervalos de estudio.
- **Seguimiento de progreso** → Proporcionar un módulo con estadísticas diarias y generales (aciertos, errores, tarjetas pendientes).
- **Gestión de cuentas** → Permitir a los usuarios registrarse, iniciar y cerrar sesión de forma segura.
- **Notificaciones automáticas** → Integrar un sistema de **correos electrónicos** personalizados que recuerden al usuario sus tarjetas pendientes y resuman su progreso.
- **Compartir mazos** → Permitir que los usuarios compartan sus categorías mediante un enlace único, para que otros puedan consultarlas y clonarlas en sus cuentas.

---

## Entidades en **PostgreSQL**

**Usuario**

- ID (IDENTITY, clave primaria)
- Nombre
- Email (único, para login)
- Contraseña (encriptada)
- Fecha de registro

**Categoría**

- ID (IDENTITY, clave primaria)
- Nombre de la categoría
- Descripción
- UsuarioID (relación con Usuario, dueño de la categoría)

**Flashcard**

- ID (IDENTITY, clave primaria)
- Frente (ej. pregunta, palabra)
- Reverso (ej. traducción, definición)
- Tipo (ej. "Revisión" o "Escritura")
- Intervalo (días hasta la próxima revisión)
- Factor de repetición (facilidad de la carta)
- Próxima fecha de revisión
- CategoríaID (relación con Categoría)

---

## Entidades en **MongoDB**

**Sesión de Estudio**

- ID (ObjectId)
- UsuarioID (referencia al usuario en PostgreSQL)
- CategoríaID (referencia a PostgreSQL)
- Hora de inicio
- Hora de fin
- Lista de respuestas del usuario

**Respuesta del Usuario**

- ID (ObjectId)
- UsuarioID (referencia al usuario en PostgreSQL)
- FlashcardID (referencia al flashcard en PostgreSQL)
- Respuesta escrita por el usuario
- Respuesta correcta
- ¿Fue correcta? (sí/no)
- Modo (Revisión o Escritura)
- Fecha del intento

**Notificación**

- ID (ObjectId)
- UsuarioID
- Tipo de notificación (ej. “Progreso diario”, “Recordatorio de repaso”)
- Contenido (mensaje enviado)
- Estado (pendiente / enviado / leído)
- Fecha de creación

---

## Historias de Usuario

### Organización de contenido

- **HU01** – Como usuario, quiero **crear una categoría o módulo**, para organizar mis tarjetas por temas.
- **HU02** – Como usuario, quiero **añadir una nueva tarjeta ingresando frente y reverso**, para registrar vocabulario nuevo fácilmente.
- **HU03** – Como usuario, quiero **editar o eliminar una tarjeta creada**, para corregir errores o actualizar mi contenido.
- **HU04** – Como usuario, quiero **ver todas mis categorías en una lista**, para acceder rápidamente al tema que quiero estudiar.
- **HU05** – Como usuario, quiero **ver todas las tarjetas de una categoría**, para estudiar específicamente un tema.

### Estudio y repaso

- **HU06** – Como usuario, quiero **marcar si recordé o no una tarjeta**, para registrar mi progreso.
- **HU11** – Como usuario, quiero **elegir entre modo revisión o escritura al estudiar una categoría**, para adaptar el estudio a mis preferencias.
- **HU12** – Como usuario, quiero **ver mi respuesta escrita y la correcta lado a lado**, para comparar y aprender de mis errores.
- **HU13** – Como usuario, quiero **que el sistema registre mis intentos de escritura**, para evaluar mi progreso en este modo.

### Seguimiento de progreso

- **HU07** – Como usuario, quiero **ver cuántas tarjetas he estudiado hoy**, para medir mi avance diario.
- **HU08** – Como usuario, quiero **consultar mis estadísticas generales**, para motivarme y saber cuánto he mejorado.

### Gestión de cuenta

- **HU09** – Como usuario, quiero **iniciar sesión con mi cuenta**, para guardar mis datos personales y progreso.
- **HU10** – Como usuario, quiero **cerrar sesión de forma segura**, para proteger mi información.

### Notificaciones

- **HU14** – Como usuario, quiero **recibir notificaciones por correo sobre mi progreso y recordatorios de estudio**, para mantenerme motivado y constante.

### Compartir mazos

- **HU15** – Como usuario, quiero **compartir mis mazos de flashcards mediante un enlace**, para que otros puedan estudiar con el mismo contenido.

---

## **Tecnologías Específicas**

- **Frontend:** HTML/CSS + Bootstrap
- **Backend:** Java + Spring Boot
- **Bases de Datos:**
    - **PostgreSQL** (datos estructurados: usuarios, categorías, flashcards)
    - **MongoDB** (datos de estudio: sesiones, respuestas, analytics)
    - **Redis** (cache y sesiones)
- **Visualización:** Power BI (para dashboards avanzados).

---

## Dependencias spring:

**Web**

- spring-boot-starter-web — levantar el servidor y exponer endpoints REST.

**SQL**

- spring-boot-starter-data-jpa — ORM con Hibernate.
- postgresql — driver de conexión a PostgreSQL.

**NoSQL**

- spring-boot-starter-data-mongodb — conexión a MongoDB (sesiones, respuestas).
- spring-boot-starter-data-redis — conexión a Redis (cache, sesiones rápidas).

**Seguridad (JWT)**

- spring-boot-starter-security — seguridad base de Spring.
- spring-boot-starter-validation — validación de inputs (ej: email, contraseñas).

**Utilidad**

- lombok — elimina código repetitivo (getters, setters, builders

**Correo**

- spring-boot-starter-mail — Para enviar notificaciones de progreso.

---

## **Frontend (visual):**

- Miembro del equipo 1: describe las responsabilidades

---

## **Backend (logico):**

- Miembro del equipo 1: describe las responsabilidades

---

## **Arquitectura y estructura de carpetas**

com.proyect.acardemy/

____config/        # Configuración (Spring Security, JWT, etc.)

________Security.java

____controller/    # Endpoints REST (ej: FlashcardController)

________CategoryController.java

________FlashcardController.java

________UserController.java

____model/        # Entidades JPA (Usuario, Categoria, Flashcard)

________Category.java

________Flashcard.java

________User.java

____repository/    # Interfaces JPA (UsuarioRepository, etc.)

________

________

________

____service/       # Lógica de negocio

________

________

________

____AcardemyApplication.java

---

## Notas

Agrega cualquier nota adicional o detalle importante relacionado con el evento.
