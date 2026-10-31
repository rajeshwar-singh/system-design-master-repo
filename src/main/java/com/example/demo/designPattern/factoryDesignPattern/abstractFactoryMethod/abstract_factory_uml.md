# Abstract Factory UML Diagram

```mermaid
classDiagram
    class Client {
        - CarInterior interior
        - CarExterior exterior
        + Client(factory: CarFactory)
        + assembleCar()
    }

    class CarFactoryProvider {
        + static getFactory(type: CarType): CarFactory
    }

    <<interface>> CarFactory
    CarFactory : +createInterior(): CarInterior
    CarFactory : +createExterior(): CarExterior

    class EconomyCarFactory {
        + createInterior(): CarInterior
        + createExterior(): CarExterior
    }

    class LuxuryCarFactory {
        + createInterior(): CarInterior
        + createExterior(): CarExterior
    }

    <<interface>> CarInterior
    class EconomyCarInterior
    class LuxuryCarInterior

    <<interface>> CarExterior
    class EconomyCarExterior
    class LuxuryCarExterior

    Client --> CarFactory
    CarFactoryProvider ..> EconomyCarFactory
    CarFactoryProvider ..> LuxuryCarFactory

    CarFactory <|.. EconomyCarFactory
    CarFactory <|.. LuxuryCarFactory

    CarInterior <|.. EconomyCarInterior
    CarInterior <|.. LuxuryCarInterior
    EconomyCarFactory ..> EconomyCarInterior : creates
    LuxuryCarFactory ..> LuxuryCarInterior : creates

    CarExterior <|.. EconomyCarExterior
    CarExterior <|.. LuxuryCarExterior
    EconomyCarFactory ..> EconomyCarExterior : creates
    LuxuryCarFactory ..> LuxuryCarExterior : creates
```
