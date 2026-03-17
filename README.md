# Al Diwan Restaurant — Java OOP System

**Course:** CS311 - Object Oriented Programming  
**University:** Imam Abdulrahman Bin Faisal University  
**Language:** Java  
**IDE:** NetBeans

---

## Project Overview

A console-based restaurant management system built with Java, applying core OOP principles. The system supports two roles — Manager and Customer — handling menu management, order processing, and payment validation.

---

## Class Structure

```
Person (abstract)
├── Customer
└── Manager

Order (abstract)
├── OnSite
└── Takeaway

Payment (interface)
├── Cash
└── Credit
```

---

## OOP Concepts Applied

| Concept | Application |
|---------|-------------|
| Abstraction | `Person`, `Order` are abstract classes; `Payment` is an interface |
| Inheritance | `Customer` and `Manager` extend `Person`; `OnSite` and `Takeaway` extend `Order` |
| Encapsulation | Private attributes accessed through public methods |
| Polymorphism | `calculateTotal()` overridden in `OnSite` and `Takeaway`; `authorized()` in `Cash` and `Credit` |

---

## Features

**Manager**
- Password-protected login
- Add, delete, and view menu items

**Customer**
- View menu and place orders
- Choose between OnSite or Takeaway (delivery fee: 15 SAR)
- Pay by Cash or Credit Card (with expiry date validation)

---

## How to Run

1. Open the project in [NetBeans](https://netbeans.apache.org/)
2. Build and run `AlDiwanRestaurant.java`
3. Follow the console prompts
4. Manager password: `mng22`

---

## Files

| File | Description |
|------|-------------|
| `AlDiwanRestaurant.java` | Main class and entry point |
| `Person.java` | Abstract base class |
| `Customer.java` | Customer role |
| `Manager.java` | Manager role with menu control |
| `Order.java` | Abstract order class + OnSite and Takeaway subclasses |
| `Payment.java` | Payment interface |
| `Cash.java` | Cash payment implementation |
| `Credit.java` | Credit card payment with expiry validation |

---

## UML Diagram

![UML Diagram](UML.png)

---

## Author

**Razan Alqahtani**  
Computer Science Student — IAU
