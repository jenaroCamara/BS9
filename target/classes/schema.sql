table persona{
id_persona int [pk, increment],
usuario string [not null max-length: 10 min-length: 6],
password string [not null],
name string [not null],
surname string,
company_email string [not null ],
personal_email string [not null],
city string [not null],
created_date date [not null],
imagen_url string,
termination_date date
}
table student{
id_student string [pk, increment],
id_persona string [ref:- persona.id_persona], -- Relación OneToOne con la tabla persona.
num_hours_week int [not null], -- Número de horas semanales del estudiante en formación
coments string,
id_profesor string [ref: > profesor.id_profesor], -- Un estudiante solo puede tener un profesor.
branch string [not null] -- Rama principal delestudiante (Front, Back, FullStack)
}

table profesor{
id_profesor string [pk, increment]
id_persona string [ref:- persona.id_persona] -- Relación OneToOne con la tabla persona.
coments string
branch string [not null] -- Materia principal que imparte. Por ejemplo: Front
}

table estudiante_asignatura{
id_asignatura String [pk, increment],
id_student string [ref: > student.id_student], -- Un estudiante puede tener N asignaturas
asignatura string, -- Ejemplo: HTML, Angular, SpringBoot...
coments string,
initial_date date [not null], -- Fecha en que estudiante empezó a estudiar la asignatura
finish_date date -- Fecha en que estudiante termina de estudiar la asignatura
}

table registry_type
{
  id_registry_type String [pk, increment],
  name string [note: "Ejemplo: Actitud"],
  last_update date,
  activo boolean
}

// Notas por estudiante y topico
table score
{
  id_score String [pk, increment]
  id_student string [ref: > student.id_student]
  id_registry_type string  [ref: > registry_type.id_registry_type]
  note float [not null] // Puede ser negativo
  branch branch [not null]
  id_topic string [ref: > topic.id_topic]
  coment string
  creationDate date [not null]
}

table student_topic{
  id_student_topic String [pk, increment]
  id_student string [ref: > student.id_student]
  id_topic string [ref: > topic.id_topic]
  coment string
  initialDate date [not null]
  finishDate date [not null]
}
table technology{
  id_technology String [pk, increment],
  branch String [not null],
  name varchar(50),
  description varchar(200)
}

table topic{
  id_topic String [pk, increment],
  id_technology string [ref: > technology.id_technology],
  name String,
  description string
}