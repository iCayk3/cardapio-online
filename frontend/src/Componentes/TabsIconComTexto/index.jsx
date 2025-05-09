import * as React from 'react';
import Tabs from '@mui/joy/Tabs';
import TabList from '@mui/joy/TabList';
import Tab from '@mui/joy/Tab';
import ListItemDecorator from '@mui/joy/ListItemDecorator';
import Stack from '@mui/joy/Stack';
import { Cake, Liquor, LocalPizza, LunchDining } from '@mui/icons-material';

export default function TabsIconComTexto({onChange}) {

  
  return (
    <Stack spacing={2} sx={{ width: '100%' }}>
      <Tabs 
        aria-label="Icon tabs" 
        onChange={(event, value) => {
          // Associa o valor numérico à string da categoria
          const categorias = ['LANCHE', 'BEBIDA', 'SALGADO', 'DOCE'];
          onChange(categorias[value]);
        }}
        >
        <TabList tabFlex={1} sx={{fontSize : 18}}>
          <Tab >
            <ListItemDecorator>
              <LunchDining />
            </ListItemDecorator>
            Lanches
          </Tab>
          <Tab>
            <ListItemDecorator>
              <Liquor />
            </ListItemDecorator>
            Bebidas
          </Tab>
          <Tab>
            <ListItemDecorator>
              <LocalPizza />
            </ListItemDecorator>
            Salgados
          </Tab>
          <Tab>
            <ListItemDecorator>
              <Cake />
            </ListItemDecorator>
            Doces
          </Tab>
        </TabList>
      </Tabs>
    </Stack>
  );
}
