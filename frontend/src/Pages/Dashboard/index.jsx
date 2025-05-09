import { useNavigate } from "react-router-dom";
import styled from "styled-components";

const DashEstilizada = styled.main`
    
`


const Dashboard = () => {

    const navigate = useNavigate();

    const sair = () => {
        console.log("Saindo do programa")
        localStorage.clear()
        navigate('/login', { replace: true }); // redireciona corretamente
    }

    return <DashEstilizada>
        <h1>Dashboard</h1>
        <button onClick={sair}>Sair</button>
    </DashEstilizada>
}

export default Dashboard