# Lab 10 — Design Patterns: Singleton & Strategy

## Overview

This lab implements a **Gourmet Coffee System** using two design patterns:

- **Strategy Pattern** — different sales output formats (Plain Text, HTML, XML) are encapsulated as interchangeable strategies behind a common interface
- **Singleton Pattern** — each formatter class has only one instance, accessed via a static factory method

The system hard-codes sample products and orders, then lets the user choose an output format at runtime.

## Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                      SalesFormatter                        │
│                      <<interface>>                         │
│                      + formatSales(Sales) : String          │
└──────────────────────────┬──────────────────────────────────┘
                           │
           ┌───────────────┼───────────────┐
           │               │               │
┌──────────▼────────┐ ┌───▼────────┐ ┌───▼─────────┐
│PlainTextSales     │ │HTMLSales   │ │XMLSales      │
│Formatter          │ │Formatter   │ │Formatter     │
├───────────────────┤ ├────────────┤ ├──────────────┤
│- singletonInstance│ │- singleton │ │- singleton   │
│+ getSingletonInst()│ │  Instance  │ │  Instance    │
└───────────────────┘ └────────────┘ └──────────────┘
                           ▲
                           │ uses
                    ┌──────┴──────┐
                    │ GourmetCoffee│  (Context)
                    │─────────────│
                    │- sales      │
                    │- formatter  │
                    └─────────────┘
```

## File Structure

```
lab10/
├── README.md                         # this file
├── docs/                             # original assignment materials
│   ├── Exercise 5.html               # assignment document
│   ├── formttr-cof-gou-sys.jpg       # class diagram
│   └── *.png                         # output screenshots
├── SampleCode/                       # in-class examples (Borrower system)
│   ├── Borrower.java
│   ├── BorrowedItems.java
│   └── PlainTextBorrowersFormatter.java
└── student-files/                    # main project files
    ├── SalesFormatter.java           # Strategy interface
    ├── PlainTextSalesFormatter.java  # Strategy: plain-text output
    ├── HTMLSalesFormatter.java       # Strategy: HTML output
    ├── XMLSalesFormatter.java        # Strategy: XML output
    ├── GourmetCoffee.java            # Context + client (main)
    ├── Product.java                  # base product model
    ├── Coffee.java                   # coffee product (extends Product)
    ├── CoffeeBrewer.java            # coffee brewer product (extends Product)
    ├── Catalog.java                  # product catalog
    ├── OrderItem.java                # item in an order
    ├── Order.java                    # single order (collection of items)
    ├── Sales.java                    # collection of paid orders
    └── *.html / resources/           # Javadoc documentation
```

## How to Run

```bash
cd student-files
javac GourmetCoffee.java
java GourmetCoffee
```

Menu options:
- `[0]` Quit
- `[1]` Display sales (Plain Text)
- `[2]` Display sales (HTML)
- `[3]` Display sales (XML)

## Key Improvements (Modern Java)

- **Generics** — `Iterator<Order>` / `Iterator<OrderItem>` replaces raw `Iterator` with no casts needed
- **StringBuilder** — efficient string building in loops instead of `+=`
- **Switch expression** — arrow-syntax `switch` replaces `if-else if` chain
- **`@FunctionalInterface`** — marks `SalesFormatter` as a functional interface (Java 8+)
- **`System.lineSeparator()`** — portable newline constant

## Design Patterns Reference

### Singleton Pattern

Each `*SalesFormatter` class uses a private constructor and a `static` factory method:

```java
private static PlainTextSalesFormatter singletonInstance;

private PlainTextSalesFormatter() {}

public static PlainTextSalesFormatter getSingletonInstance() {
    if (singletonInstance == null) {
        singletonInstance = new PlainTextSalesFormatter();
    }
    return singletonInstance;
}
```

See `SampleCode/PlainTextBorrowersFormatter.java` for a parallel example.

### Strategy Pattern

- **`SalesFormatter`** (interface) — declares `formatSales(Sales)`
- **`PlainTextSalesFormatter`**, **`HTMLSalesFormatter`**, **`XMLSalesFormatter`** — concrete strategies
- **`GourmetCoffee`** — context, holds a `SalesFormatter` reference and delegates formatting
