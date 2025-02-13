
# Agendador de Notificações
Este projeto foi desenvolvido para um desafio técnico visando apresentar habilidades de desenvolvedor java backend e tem como escopo o cadastro de Notificações para posterior envio.


## Rodando localmente

Clone o projeto

```bash
  git clone https://link-para-o-projeto
```

Entre no diretório do projeto

```bash
  docker-compose up --build
```

## Documentação da API

#### Cadastra notificações pendentes

```http
  POST /agendamento
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `emailDestinatario` | `string` | **Obrigatório**. Email do destinatário da notificação |
| `telefoneDestinatario` | `string` | **Obrigatório**. Telefone do destinatário da notificação |
| `message` | `string` | **Obrigatório**. Mensagem da notificação |
| `dataHoraEnvio` | `LocalDateTime` | **Obrigatório**. Data hora do envio no formato dd-MM-yyyy HH:mm:ss |

#### Retorna uma notificação por id

```http
  GET /agendamento/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer buscar |

#### Cancela uma notificação por id

```http
  PUT /agendamento/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer cancelar |



## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  nvn test
```

