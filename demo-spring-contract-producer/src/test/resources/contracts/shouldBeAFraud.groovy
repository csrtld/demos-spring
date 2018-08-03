import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url '/get-example'
    }

    response {
        status 200
        body ("""
        {
            "mensaje": "Hola Mundo CDC"
        }
        """)
        headers {
            contentType applicationJson()
        }
    }
}
