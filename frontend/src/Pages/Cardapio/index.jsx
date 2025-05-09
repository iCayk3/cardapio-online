import styled from "styled-components"
import CardItem from "../../Componentes/CardItem"
import TabsIconComTexto from "../../Componentes/TabsIconComTexto"
import Api from "../../Service/Api"
import { useEffect, useState } from "react"


const CardapioEstilizado = styled.main`
    display: flex;
    flex-direction: column;
    gap: 1rem;
    width: 80%;
    margin: 0 auto; /* Centraliza horizontalmente */

    .categorias {
        box-sizing: border-box;
    }

    .itens {    
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        gap: 20px;
        grid-template-rows: auto;
    }
`

const Cardapio = () => {

    const UseApi = Api();
    const [categoria, setCategoria] = useState('LANCHE')
    const [dados, setDados] = useState([])

    useEffect(() => {
        const fetchData = async () => {
            try {
// obtém a função de chamada
                const response = await UseApi(`item?categoria=${categoria}`); // faz a requisição
                setDados(response)
            } catch (error) {
                console.error('Erro ao buscar dados:', error);
            }
        };

        fetchData();
    }, [categoria]);

    return <CardapioEstilizado>
        <div className="categorias">
            <TabsIconComTexto onChange={setCategoria}/>
        </div>
        <div className="itens">
            {dados && dados.map((item, index) => (
                <div key={index}>
                    <CardItem
                        nome={item.nome} 
                        valor={item.valor}
                        imagem={item.imagem}
                        descricao={item.descricao}
                    />
                </div>
            ))}
        </div>
    </CardapioEstilizado>
}

export default Cardapio