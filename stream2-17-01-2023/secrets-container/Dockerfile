FROM golang:1.18-alpine as builder

COPY . /app
WORKDIR /app

RUN go build -o hello

FROM alpine:3.16

COPY --from=builder /app/hello /app/hello

RUN mkdir ~/.aws
RUN echo AWS_ACCESS_KEY_ID=AKIAUDSMZPA6BXEQSCX6 > ~/.aws/credentials
RUN echo AWS_SECRET_ACCESS_KEY=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 >> ~/.aws/credentials

# Do stuff with AWS credentials

RUN rm ~/.aws/credentials

ENTRYPOINT ["/app/hello"]