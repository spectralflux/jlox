package com.craftinginterpreters.lox;

import com.craftinginterpreters.lox.Expr.Assign;
import com.craftinginterpreters.lox.Expr.Call;
import com.craftinginterpreters.lox.Expr.Get;
import com.craftinginterpreters.lox.Expr.Logical;
import com.craftinginterpreters.lox.Expr.Set;
import com.craftinginterpreters.lox.Expr.Super;
import com.craftinginterpreters.lox.Expr.This;
import com.craftinginterpreters.lox.Expr.Variable;

// Creates an unambiguous, if ugly, string representation of AST nodes.
// TODO half empty, delete?
class AstPrinter implements Expr.Visitor<String> {

  String print(Expr expr) {
    return expr.accept(this);
  }

  @Override
  public String visitAssignExpr(Assign expr) {
    return null;
  }

  @Override
  public String visitBinaryExpr(Expr.Binary expr) {
    return parenthesize(expr.operator.lexeme, expr.left, expr.right);
  }

  @Override
  public String visitCallExpr(Call expr) {
    return null;
  }

  @Override
  public String visitGetExpr(Get expr) {
    return null;
  }

  @Override
  public String visitGroupingExpr(Expr.Grouping expr) {
    return parenthesize("group", expr.expression);
  }

  @Override
  public String visitLiteralExpr(Expr.Literal expr) {
    if (expr.value == null) {
      return "nil";
    }
    return expr.value.toString();
  }

  @Override
  public String visitLogicalExpr(Logical expr) {
    return null;
  }

  @Override
  public String visitSetExpr(Set expr) {
    return null;
  }

  @Override
  public String visitSuperExpr(Super expr) {
    return null;
  }

  @Override
  public String visitThisExpr(This expr) {
    return null;
  }

  @Override
  public String visitUnaryExpr(Expr.Unary expr) {
    return parenthesize(expr.operator.lexeme, expr.right);
  }

  @Override
  public String visitVariableExpr(Variable expr) {
    return null;
  }

  private String parenthesize(String name, Expr... exprs) {
    StringBuilder builder = new StringBuilder();

    builder.append("(").append(name);
    for (Expr expr : exprs) {
      builder.append(" ");
      builder.append(expr.accept(this));
    }
    builder.append(")");

    return builder.toString();
  }
}