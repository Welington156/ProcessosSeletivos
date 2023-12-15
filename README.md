# ProcessosSeletivos
Diagrama de Classes:
![image](https://github.com/Welington156/ProcessosSeletivos/assets/52759304/740f1b32-8e6b-459b-ae7a-28913df28dc0)

É necessário configurar jboss para autenticação funcionar corretamente:

/subsystem=elytron/policy=jacc:add(jacc-policy={})

/subsystem=undertow/application-security-domain=other:write-attribute(name=integrated-jaspi, value=false)

:reload

Usuarios inicias:

  Nome             Email          Senha       Perfil
  
"Emilly"  "candidato@gmail.com"  "1234"    Perfil.CANDIDATO

"Caua"    "admin@gmail.com"      "1234"    Perfil.ADMINISTRADOR

"Junio"   "editor@gmail.com"     "1234"    Perfil.EDITOR
