# Stage 2 - Create the run-time image
FROM debian:latest
RUN apt-get update
RUN apt-get install -y curl git wget python3 sed
RUN apt-get clean
COPY build/web /web
WORKDIR /web
EXPOSE 80
ENTRYPOINT [ "python3", "-m", "http.server", "80" ]