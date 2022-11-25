# Real-Time Payment Processing System

## Description

This project aims to develop a highly scalable and fault-tolerant real-time payment processing system capable of handling concurrent transactions. The system is built using a microservices architecture, event-driven design, and distributed computing principles to ensure reliability.

## Key Features

- **Microservices Architecture**:

  - Decomposes the system into independent microservices, such as:
    - Payment Gateway Service
    - Transaction Processing Service
    - Settlement Service
  - Each microservice handles a specific business capability.

- **Event-Driven Architecture**:

  - Utilizes Apache Kafka for asynchronous communication between microservices.
  - Decouples components to enable better scalability and fault tolerance.

- **Distributed Transaction Processing**:

  - Ensures data consistency and integrity across PostgreSQL and NoSQL databases.
  - Supports high volumes of concurrent transactions.

## Images

<img width="670" alt="Mongo_Tran" src="https://github.com/user-attachments/assets/01d9efb8-778e-4c8a-9d95-094a57b22eae" />

<img width="670" alt="PostgreSQL_Tran" src="https://github.com/user-attachments/assets/85f1cce2-6b10-4d6e-9086-758ca7228fc4" />

## Technology Stack

- **Programming Language**: Java (Spring Boot)
- **Message Broker**: Apache Kafka
- **Databases**:
  - Relational: PostgreSQL
  - NoSQL: MongoDB (or other NoSQL databases as needed)
- **Frameworks**:
  - Spring Boot for microservices development
  - Spring Data for database access
- **Containerization**: Docker

### Architecture Diagram

```
[Client]
   |
   v
[Payment Gateway Service] --> [Apache Kafka] --> [Transaction Processing Service] --> [Databases (PostgreSQL/NoSQL)]
                                                    |
                                                    v
                                         [Settlement Service]
```

### Key Components

1. **Payment Gateway Service**: Handles incoming payment requests and performs basic validation before passing messages to Kafka.
2. **Transaction Processing Service**: Manages the core business logic for processing transactions, ensuring data consistency, and updating the database.
3. **Settlement Service**: Finalizes transactions by reconciling with external financial institutions and updating the system's records.
4. **Apache Kafka**: Enables asynchronous, reliable communication between services.

## Prerequisites

1. Java 17 or later
2. Apache Kafka
3. PostgreSQL and MongoDB
4. Docker (optional, for containerized deployment)
5. Maven or Gradle (for build management)

## Usage

### API Endpoints

1. **Payment Gateway**:

   - `POST /api/payments` - Initiates a payment.

2. **Transaction Processing**:

   - `GET /api/transactions/{id}` - Retrieves transaction details.

3. **Settlement**:
   - `GET /api/settlements/{id}` - Retrieves settlement status.

### Sample Request

```json
POST /api/payments
{
  "amount": 100.0,
  "currency": "INR",
  "source": "card",
  "destination": "merchant_account"
}
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or feedback, please contact:

- **Name**: Shamon Hashmi
- **Email**: shamonhashmi148@gmail.com
- **GitHub**: [shamonhashmi](https://github.com/shamonhashmi)
