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

#+end_src
MIT License

Copyright (c) [Year] Nathan Martins Cunha

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
#+begin_src 

## Prerequisites
--------------

Before running the project, ensure you have the following prerequisites installed:

*   Docker
*   Docker Compose
*   Java 21
*   Gradle 8.10.2 or later

## Run the Project
-----------------

To run the project, follow these steps:

1.  Clone the repository using Git:

    #+end_src
git clone https://github.com/[your-username]/coffee-finder.git
#+begin_src 
2.  Navigate to the project directory:

    #+end_src
cd coffee-finder
#+begin_src 
3.  Start the Docker containers using Docker Compose:

    #+end_src
docker-compose -f compose-dev.yaml up -d
#+begin_src 
4.  Build the project using Gradle:

    #+end_src
gradle build
#+begin_src 
5.  Run the application:

    #+end_src
gradle bootRun
#+begin_src 
    Alternatively, you can use the `bootRunDev` task to run the application with the dev profile:

    #+end_src
gradle bootRunDev
#+begin_src 
6.  Access the application at <http://localhost:8080>.

## Build and Deployment
---------------------

To build and deploy the project, follow these steps:

1.  Build the Docker image using the `Dockerfile`:

    #+end_src
docker build -t coffee-finder .
#+begin_src 
2.  Push the Docker image to a container registry like Docker Hub.
3.  Create a new container instance from the Docker image:

    #+end_src
docker run -p 8080:8080 -d --name coffee-finder coffee-finder
#+begin_src 
4.  Access the application at <http://localhost:8080>.

Note: This is just a sample README file, and you should update it to reflect the specific details of your project.
#+end_src

Here is a basic usage example:

Create a =Merchant= entity and persist it to the database.
#+begin_src java
Merchant merchant = new Merchant("Coffee Shop", "1234567890", "example@gmail.com", "https://coffeeshop.com");
merchant.setLocation(new Location("Street Address", "City", "State", "Zip"));
MerchantRepository.save(merchant);
#+end_src
