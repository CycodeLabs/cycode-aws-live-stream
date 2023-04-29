# Demo Repositories of Cycode and AWS Collaboration Live Stream on Twitch!

Cycode research team collaborated with the AWS Development Relations team to promote a series of streams live-showing interesting security concepts for the development community.

The series is called #TheBigDevTheory, and together with AWS, we did three streams covering various aspects of securing CI/CD processes and the software supply chain. The repositories used in each stream are here to help developers and security enthusiasts experiment with the concept we showcased.

## January 10, 2023 - Implementing modern CI/CD pipeline using Github and AWS

URL to the video: https://www.twitch.tv/videos/1778017615

The repository ([stream1-10-01-2023](./stream1-10-01-2023/)) contains a simple "hello world" program that was automatically deployed from code to the cloud through Github Actions workflows.

The flow for the program is as follows:

- Compiling simple go program into a docker container
- Pushing the docker container to ECR (Elastic Container Registry)
- Deploying the container from ECR to EKS (Elastic Kubernetes Service)

## January 17, 2023 - Got Security Risks In Your Pipeline?

URL to the video: https://www.twitch.tv/videos/1778034229

The repository ([stream2-17-01-2023](./stream2-17-01-2023/)) contains several examples of common security risks developers face nowadays, such as:

- Hardcoded secrets in the repository
- Hardcoded secrets in container images
- Vulnerability
- And more

We will learn about some of these security issues and see how they could affect our production environment.

## January 24, 2023 - Learning from Log4j incident - How open source vulnerabilities can compromise your software

URL to the video: https://www.twitch.tv/videos/1778034293

The repository ([stream3-24-01-2023](./stream3-24-01-2023/)) contains a complete demonstration of the Log4j vulnerability (CVE-2021-44832), from how it is introduced to how it can be easily exploited to steal sensitive information from the production environment.