const apiUrl = "http://localhost:8080/";
const token = localStorage.getItem("token");

export default function Api() {
    return async (endpoint, method = "GET", body = null) => {
        const headers = {
            "Content-Type": "application/json",
        };

        // Adiciona o token se ele existir
        if (token) {
            headers["Authorization"] = `Bearer ${token}`;
        }

        const options = {
            method,
            headers,
            body: body ? JSON.stringify(body) : null
        };

        const response = await fetch(`${apiUrl}${endpoint}`, options);

        if (!response.ok) {
            const error = new Error('Erro na requisição');
            error.status = response.status;
            throw error;
        }

        return response.json();
    };
}
