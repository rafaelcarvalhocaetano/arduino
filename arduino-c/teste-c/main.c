#include <stdio.h>
#include <mysql.h>

void main()
{
    MYSQL conexao;
    MYSQL_RES *resp;
    MYSQL_ROW linhas;
    MYSQL_FIELD *campos;
    char query[] = "SELECT * FROM conexao";
    int conta;

     mysql_init(&conexao);
     if( mysql_real_connect(&conexao, "localhost", "root", "q1w2e3r4", "conectandoc", 0, NULL, 0))
    {
        printf("Conectado com sucesso ... ");
        if(mysql_query(&conexao, query))
        {
            printf("Erro %d : %s", mysql_error(&conexao), mysql_errno(&conexao));
        }else
        {
            resp = mysql_store_result(&conexao);
            if(resp)
            {
                campos = mysql_fetch_field(resp);
                for(conta = 0; conta<mysql_num_fields(resp); conta++)
            {
                printf("%s", (campos[conta]).name);
                if(mysql_num_fields(resp) > 1)
                    printf("\t");
            }
            printf("\n");
            while((linhas = mysql_fetch_row(resp)) != NULL)
            {
                for(conta=0; conta<mysql_num_fields(resp);conta++)
                {
                    printf("%s\t", linhas[conta]);
                    printf("\n");
                }
            }
            mysql_free_result(resp);
            }
            mysql_close(&conexao);
        }
    }
        else
        {
            printf("Conexão falhou...");
            if(mysql_errno(&conexao))
            {
                printf("Erro %d : %s", mysql_error(&conexao), mysql_errno(&conexao));
            }
            return 0;

        }
}
