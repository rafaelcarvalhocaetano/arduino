#include <stdio.h>
#include <stdlib.h>
#include <mysql.h>

MYSQL *con;
MYSQL_RES *res;
MYSQL_ROW row;

static char *server = "localhost";
static char *user = "root";
static char *pass = "q1w2e3r4";
static char *db = "conectandoc";

int main()
{
    //CONECTANDO AO BANCO
    con = mysql_init(NULL);
    if(!mysql_real_connect(con, server, user, pass, db, 0, NULL, 0)){
        fprintf(stderr, "%s\n", mysql_error(con));
    }
    //COMANDO
    if(mysql_query(con, "show DB")){
        fprintf(stderr, "%s\n", mysql_error(con));
        exit(1);
    }
    res = mysql_use_result(con);
    printf("CONECTADO COM MYSQL...");

    while((row = mysql_fetch_row(res)) != NULL)
    {
        printf("%s \n", row[0]);

    }
    mysql_free_result(res);
    mysql_close(con);

    system("pause");
    return 0;
}
