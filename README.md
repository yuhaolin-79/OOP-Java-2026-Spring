# OOP Java — 2026 Spring

Object-Oriented Programming (Java) course notes and code.

This is a **bilingual** course (Chinese & English). All lecture slides, exams, and code are in English.

## Structure

```
├── README.md
└── lecture1/
    ├── lecture1note.md      # Unit 1.1 — Java Applications (notes)
    ├── image.png             # Java platform architecture diagram
    ├── image-1.png           # Java platform version evolution
    └── src/
        ├── HelloWorld.java   # First Java program
        └── HelloWorld.class  # Compiled bytecode
```

## Contents

### Lecture 1 — Java Basics

- Java compilation and execution workflow (`.java` → `javac` → `.class` → `JVM`)
- Java platform editions: Java SE, Jakarta EE, legacy platform overview
- Key differences between Java and C (OOP paradigm, type system, memory management)
- Writing and running a HelloWorld application

## Requirements

- JDK 17+
- Any Java IDE (IntelliJ IDEA or VS Code recommended)

## Run

```bash
cd lecture1/src
javac HelloWorld.java
java HelloWorld
```
