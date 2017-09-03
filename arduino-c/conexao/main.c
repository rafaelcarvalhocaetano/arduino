#include <stdio.h>
#include <mysql/mysql.h>

int main(void)
{
	MYSQL con;

	mysql_init(&con);
	if(mysql_real_connect(&con, "localhost", "root", "q1w2e3r4", "conectandoc", 0, NULL, 0))
	{
		printf("Conectado com sucesso! \n");
		mysql_close(&con);
	}
	else
	{
		printf("Falaha de conexao \n");
		printf("Erro %d : %s \n", mysql_errno(&con), mysql_error(&con));
	}
}
