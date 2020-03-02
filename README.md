# Rho Template Project

This project contains a template project for generating Rho Flink Jars

## Syntax

Syntax is similar to gitter8 syntax.
Keywords put in between $$ are taken to be tokens which need to be replaced.
If the CLI does not recognize the keyword it will not be replaced, leading to a project which will not compile.

This structure: ${block}separator::repeater$ may be used to achieve repetition. The block is repeated as many times as the repeater is defined, usign separator as the separator (\n may be used).

## Usage
Assuming you have sfaas CLI installed there should be no need to interact directly with this repository.

```
sfaas init -n NameOfNamespace -f nameOfFunction1 nameOfFunction2

```
This should clone this repo and substitute the necessary information in the template project. Creating a folder in ~/sfaas/NameOfNamespace containing the result
