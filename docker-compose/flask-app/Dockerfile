#https://hub.docker.com/_/python
# Use an official Python runtime as a parent image
FROM python:3.8-slim
RUN apt-get update && apt-get install -y procps less wget curl net-tools
RUN pip install flask requests

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container as /app
COPY . /app

# Make port 80 available to services on the same docker network
EXPOSE 80

# Define environment variable
ENV NAME World

# Run app.py when the container launches
CMD python flask_app.py
