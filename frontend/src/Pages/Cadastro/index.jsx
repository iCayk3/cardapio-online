import { useState } from "react";
import InputLabel from "../../Componentes/InputLabel";
import { Button } from "@mui/joy";
import styled from "styled-components";
import Api from "../../Service/Api";

const CadastroEstilizado = styled.main`

    display: flex;
    justify-content: center;
    height: 100vh;
    margin-top: 3rem;    

    form{
        display: flex;
        gap: 20px;
        flex-direction: column;
    }
    .botoes {
        display: flex;
        gap: 10px;
    }
        
`
const Cadastro = () => {

    const [usuario, setUsuario] = useState('');
    const [senha, setSenha] = useState('');
    const UseApi = Api();
    const [erroCode, setErrorCode] = useState(200)


    const aoAlteradoUsuario = (e) => {
        e.preventDefault();
        setUsuario(e.target.value);
        setErrorCode(200)
    };

    const validarSenha = (valor) => {
        const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?#&])[A-Za-z\d@$!%*?#&]{8,}$/;

        if (!regex.test(valor)) {
            setErrorCode(403);
        } else {
            setErrorCode(200);
        }
        setSenha(valor);
    };

    const cadastrar = async (e) => {
        e.preventDefault();
        try {
            const form = { usuario, senha };
            const response = await UseApi('usuario/cadastro', 'POST', form);
            console.log(response)
        } catch (error) {
            setErrorCode(error.status)
            console.error('Erro ao fazer login:', error);
        }
    };

    return <CadastroEstilizado>
        <form onSubmit={cadastrar}>
            <h1>CADASTRAR USUARIO TOP LANCHES</h1>
            {erroCode === 409 ?
                <InputLabel
                    valor={usuario}
                    aoAlterado={aoAlteradoUsuario}
                    label="Login"
                    cor="danger"
                    tamanho="lg"
                    variante="outlined"
                    messagem="Usuario ja cadastrado"
                    status={erroCode}
                /> : <InputLabel
                    valor={usuario}
                    aoAlterado={aoAlteradoUsuario}
                    label="Login"
                    cor="neutral"
                    tamanho="lg"
                    variante="outlined"
                />
            }
            {erroCode === 403 && senha !== '' ?
                < InputLabel
                    valor={senha}
                    aoAlterado={(e) => validarSenha(e.target.value)}
                    label="Senha"
                    tamanho="lg"
                    variante="outlined"
                    tipo="password"
                    messagem="'A senha deve ter pelo menos 8 caracteres, incluindo letra maiúscula, minúscula, número e caractere especial.'"
                    status={erroCode}
                />
                :
                <InputLabel
                    valor={senha}
                    aoAlterado={(e) => validarSenha(e.target.value)}
                    label="Senha"
                    cor="neutral"
                    tamanho="lg"
                    variante="outlined"
                    tipo="password"
                />

            }

            <div className="botoes">
                <Button variant="solid" sx={{ width: '100%', backgroundColor: 'action.active' }} type="submit">
                    Cancelar
                </Button>
                <Button variant="solid" sx={{ width: '100%', backgroundColor: 'action.active' }} type="submit">
                    Cadastrar
                </Button>
            </div>
        </form>
    </CadastroEstilizado>
}

export default Cadastro