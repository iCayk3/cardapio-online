import styled from "styled-components";
import InputLabel from "../../Componentes/InputLabel";
import { Button, Link, ThemeProvider } from "@mui/joy";
import { color, createTheme } from "@mui/system";
import { useEffect, useState } from "react";
import Api from "../../Service/Api";
import { useNavigate } from "react-router-dom";

const LoginEstilizado = styled.main`
    background-color: #1F1B2C;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    gap: 100px;
    color: #7FFBC5;

    .formulario {
        gap: 30px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

    .logo-titulo {
        display: flex;
        flex-direction: column;
        justify-content: center;
        text-align: center;
        gap: 40px;
    }

    .logo-titulo h1 {
        font-size: 3rem;
    }

    .logo-titulo img {
        width: 30rem;
    }

    form {
        height: 50vh;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2),
                    0 6px 20px 0 rgba(0, 0, 0, 0.19);
        width: 30rem;
        background-color: #1f1b2c1d;
        box-sizing: border-box;
        border-radius: 8px;
        align-items: center;
        justify-content: center;
        display: flex;
        flex-direction: column;
        gap: 40px;
    }
`

const estilos = {
    color : '#7FFBC5'
}

const theme = createTheme({
    palette: {
        background: {
            paper: '#fff',
        },
        text: {
            primary: '#173A5E',
            secondary: '#46505A',
        },
        action: {
            active: '#7FFBC5',
        },
        success: {
            dark: '#009688',
        },
        '&:hover': {
            color: 'red',
            backgroundColor: 'white',
        }
    },
});

const Login = () => {
    const [usuario, setUsuario] = useState('');
    const [senha, setSenha] = useState('');
    const UseApi = Api();
    const navigate = useNavigate();

    const aoAlteradoUsuario = (e) => {
        e.preventDefault();
        setUsuario(e.target.value);
    };

    const aoAlteradoSenha = (e) => {
        e.preventDefault();
        setSenha(e.target.value);
    };

    const logar = async (e) => {
        e.preventDefault();
        try {
            const form = { usuario, senha };
            const response = await UseApi('usuario/login', 'POST', form);

            if (response?.token) {
                localStorage.setItem('token', response.token);
                navigate('/', { replace: true }); // redireciona corretamente
            } else {
                console.error('Token não encontrado na resposta');
            }
        } catch (error) {
            console.error('Erro ao fazer login:', error);
        }
    };

    useEffect(() => {
        const token = localStorage.getItem('token');
        if (token) {
            navigate('/', { replace: true });
        }
    }, [navigate]);

    return (
        <LoginEstilizado>
            <ThemeProvider theme={theme}>
                <div className="logo-titulo">
                    <h1 className="titulo-principal">Efetue o login no seu sistema!</h1>
                    <img src="imagens/lanche.fw.png" alt="imagem de lanche" />
                </div>
                <div className="formulario">
                    <form onSubmit={logar}>
                        <h1>TOP LANCHES</h1>
                        <InputLabel
                            valor={usuario}
                            aoAlterado={aoAlteradoUsuario}
                            label="Login"
                            cor="neutral"
                            tamanho="lg"
                            variante="outlined"
                            estilos={estilos}
                        />
                        <InputLabel
                            valor={senha}
                            aoAlterado={aoAlteradoSenha}
                            label="Senha"
                            cor="neutral"
                            tamanho="lg"
                            variante="outlined"
                            tipo="password"
                            estilos={estilos}

                        />
                        <div>
                            <Button variant="solid" sx={{ width: '55%', backgroundColor: 'action.active' }} type="submit">
                                Logar
                            </Button>
                            <Link href="#variants">Cadastra-se</Link>
                        </div>
                    </form>
                </div>
            </ThemeProvider>
        </LoginEstilizado>
    );
};

export default Login;
