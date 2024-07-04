
# Hospital Management System Backend APIs


This project provides backend APIs for a platform where doctors can register their patients and patients can receive suggestions based on their symptoms.


## Acknowledgements

I would like to acknowledge myself, [ANAND], for the sole development and implementation of this project. From conceptualization to deployment, every aspect of this project reflects my dedication and effort.


## API Reference

### Add Doctor

```http
  POST /doctors
```

Adds a new doctor to the platform.

#### Request Body

- `name`: Doctor's name (string)
- `city`: City of practice (string: Delhi, Noida, Faridabad)
- `email`: Doctor's email address (string)
- `phoneNumber`: Doctor's phone number (string: minimum 10 digits)
- `speciality`: Doctor's specialty (string: Orthopaedic, Gynecology, Dermatology, ENT)

#### Response

- `200 OK` on success with the added doctor object.
- `400 Bad Request` if validation fails.

---

### Remove Doctor

```http
  DELETE /doctors/{id}
```

Removes a doctor from the platform.

#### Path Parameters

- `id`: ID of the doctor to remove (string)

#### Response

- `204 No Content` on success.
- `404 Not Found` if the doctor with the specified ID does not exist.

---

### Add Patient

```http
  POST /patients
```

Adds a new patient to the platform.

#### Request Body

- `name`: Patient's name (string)
- `city`: Patient's city (string)
- `email`: Patient's email address (string)
- `phoneNumber`: Patient's phone number (string: minimum 10 digits)
- `symptom`: Patient's symptom (string: Arthritis, Back Pain, Dysmenorrhea, Skin infection, Skin burn, Ear pain)

#### Response

- `200 OK` on success with the added patient object.
- `400 Bad Request` if validation fails.

---

### Remove Patient

```http
  DELETE /patients/{id}
```

Removes a patient from the platform.

#### Path Parameters

- `id`: ID of the patient to remove (string)

#### Response

- `204 No Content` on success.
- `404 Not Found` if the patient with the specified ID does not exist.

---

### Suggest Doctors

```http
  GET /suggestions/{patientId}
```

Suggests doctors based on a patient's symptom and location.

#### Path Parameters

- `patientId`: ID of the patient to suggest doctors for (string)

#### Response

- `200 OK` on success with a list of suggested doctors.
- `400 Bad Request` if the patient with the specified ID does not exist.
- `404 Not Found` if no doctors are available for the patient's symptom or location.

---


## Features

- Doctor Management: Allows adding and removing doctors from the platform.
- Patient Management: Facilitates adding and removing patients with specific symptoms.
- Symptom-based Doctor Suggestion: Provides functionality to suggest doctors based on a patient's symptom and location.
- Validation: Ensures data integrity with validations for fields like name, city, email, and phone number.
- Location-specific Services: Supports operations specific to cities like Delhi, Noida, and Faridabad.
- Specialized Medical Fields: Manages doctors specializing in Orthopaedic, Gynecology, Dermatology, and ENT.
- RESTful APIs: Implements REST APIs for seamless integration and interaction with the platform.


## Screenshots

![API Screenshot](https://1drv.ms/i/c/7fed2cdf79fc72a6/EWeS-6CeSrhNn_eDTxpuJrYB1uH6gQ_6ghsHVqqtA9x9vQ?e=cy5xmr)
![API Screenshot](https://1drv.ms/i/c/7fed2cdf79fc72a6/EchQcx7x791IpFDX8Ksr40kBagc0Z6fKLTHjUlTrkEwmDQ?e=USTHX4)

