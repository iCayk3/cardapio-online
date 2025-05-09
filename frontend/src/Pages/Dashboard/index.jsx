import { useNavigate } from "react-router-dom";


const Dashboard = () => {

    const navigate = useNavigate();

    const sair = () => {
        console.log("Saindo do programa")
        localStorage.clear()
        navigate('/login', { replace: true }); // redireciona corretamente
    }

    return <>
        <h1>Dashboard</h1>
        <button onClick={sair}>Sair</button>
    </>
}

export default Dashboard