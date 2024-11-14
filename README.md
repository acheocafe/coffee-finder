## Coffee Finder
================

Coffee Finder is a web application built with Spring Boot, designed to help users find their favorite coffee shops and merchants.

## Table of Contents
-----------------

*   [About](#about)
*   [License](#license)
*   [Prerequisites](#prerequisites)
*   [Run the Project](#run-the-project)
*   [Build and Deployment](#build-and-deployment)

## About
--------

Coffee Finder is an open-source project that utilizes Spring Boot, PostgreSQL, and Docker to create a scalable and maintainable web application. The project aims to provide a platform for users to discover and explore various coffee shops and merchants, making it easier for them to find their perfect cup of coffee.

## License
-------

This project is licensed under the MIT License, a widely used and permissive free software license.


MIT License

Copyright (c) [2024] Nathan Martins Cunha

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Prerequisites
--------------

Before running the project, ensure you have the following prerequisites installed:

*   Docker: a containerization platform for building, shipping, and running applications
*   Docker Compose: a tool for defining and running multi-container Docker applications
*   Java 21: a programming language for developing large-scale applications
*   Gradle 8.10.2 or later: a build tool for automating the compilation, testing, and deployment of applications

## Run the Project
-----------------

1.  Clone the repository using Git:

```bash
git clone https://github.com/[your-username]/coffee-finder.git
```

2.  Navigate to the project directory:
```bash
cd coffee-finder
```

3.  Start the Docker containers using Docker Compose:

```bash
docker-compose -f compose-dev.yaml up -d
```

4.  Build the project using Gradle:

```bash
gradle build
```

5.  Run the application:

```bash
gradle bootRun
```

Alternatively, you can use the `bootRunDev` task to run the application with the dev profile:

```bash
gradle bootRunDev
```

6.  Access the application at <http://localhost:8080>.

...

## Build and Deployment
---------------------

To build and deploy the project, follow these steps:

1.  Build the Docker image using the `Dockerfile`:

```bash
docker build -t coffee-finder .
```
2.  Push the Docker image to a container registry like Docker Hub.
3.  Create a new container instance from the Docker image:

```bash
docker run -p 8080:8080 -d --name coffee-finder coffee-finder
```
 
4.  Access the application at <http://localhost:8080>.

