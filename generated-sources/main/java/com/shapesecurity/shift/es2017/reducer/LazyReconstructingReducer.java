// Generated by reducer-lazy-clone.js
/**
 * Copyright 2018 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.shapesecurity.shift.es2017.reducer;

import com.shapesecurity.functional.data.ImmutableList;
import com.shapesecurity.functional.data.Maybe;
import com.shapesecurity.shift.es2017.ast.*;
import javax.annotation.Nonnull;

public class LazyReconstructingReducer implements Reducer<Node> {
    public static <A extends Node, B extends Node> boolean listRefEquals(ImmutableList<A> a, ImmutableList<B> b) {
        return a.length == b.length && !a.zipWith((l, r) -> l == r, b).exists(v -> !v); // I would prefer .every instead of !.exists(!), but we don't seem to have that
    }

    public static <A extends Node, B extends Node> boolean maybeRefEquals(Maybe<A> a, Maybe<B> b) {
        return a.isJust() == b.isJust() && a.maybe(true, l -> l == b.fromJust());
    }

    public static <A extends Node, B extends Node> boolean listMaybeRefEquals(ImmutableList<Maybe<A>> a, ImmutableList<Maybe<B>> b) {
        return a.length == b.length && !a.zipWith(LazyReconstructingReducer::maybeRefEquals, b).exists(v -> !v);
    }


    @Nonnull
    @Override
    public AssignmentTarget reduceArrayAssignmentTarget(
            @Nonnull ArrayAssignmentTarget node,
            @Nonnull ImmutableList<Maybe<Node>> elements,
            @Nonnull Maybe<Node> rest) {
        if (listMaybeRefEquals(node.elements, elements) && maybeRefEquals(node.rest, rest)) {
            return node;
        }
        return new ArrayAssignmentTarget(elements.map(x -> x.map(y -> (AssignmentTargetAssignmentTargetWithDefault) y)), rest.map(x -> (AssignmentTarget) x));
    }

    @Nonnull
    @Override
    public Binding reduceArrayBinding(
            @Nonnull ArrayBinding node,
            @Nonnull ImmutableList<Maybe<Node>> elements,
            @Nonnull Maybe<Node> rest) {
        if (listMaybeRefEquals(node.elements, elements) && maybeRefEquals(node.rest, rest)) {
            return node;
        }
        return new ArrayBinding(elements.map(x -> x.map(y -> (BindingBindingWithDefault) y)), rest.map(x -> (Binding) x));
    }

    @Nonnull
    @Override
    public Expression reduceArrayExpression(
            @Nonnull ArrayExpression node,
            @Nonnull ImmutableList<Maybe<Node>> elements) {
        if (listMaybeRefEquals(node.elements, elements)) {
            return node;
        }
        return new ArrayExpression(elements.map(x -> x.map(y -> (SpreadElementExpression) y)));
    }

    @Nonnull
    @Override
    public Expression reduceArrowExpression(
            @Nonnull ArrowExpression node,
            @Nonnull Node params,
            @Nonnull Node body) {
        if (node.params == params && node.body == body) {
            return node;
        }
        return new ArrowExpression(node.isAsync, (FormalParameters) params, (FunctionBodyExpression) body);
    }

    @Nonnull
    @Override
    public Expression reduceAssignmentExpression(
            @Nonnull AssignmentExpression node,
            @Nonnull Node binding,
            @Nonnull Node expression) {
        if (node.binding == binding && node.expression == expression) {
            return node;
        }
        return new AssignmentExpression((AssignmentTarget) binding, (Expression) expression);
    }

    @Nonnull
    @Override
    public AssignmentTargetIdentifier reduceAssignmentTargetIdentifier(@Nonnull AssignmentTargetIdentifier node) {
        return node;
    }

    @Nonnull
    @Override
    public AssignmentTargetProperty reduceAssignmentTargetPropertyIdentifier(
            @Nonnull AssignmentTargetPropertyIdentifier node,
            @Nonnull Node binding,
            @Nonnull Maybe<Node> init) {
        if (node.binding == binding && maybeRefEquals(node.init, init)) {
            return node;
        }
        return new AssignmentTargetPropertyIdentifier((AssignmentTargetIdentifier) binding, init.map(x -> (Expression) x));
    }

    @Nonnull
    @Override
    public AssignmentTargetProperty reduceAssignmentTargetPropertyProperty(
            @Nonnull AssignmentTargetPropertyProperty node,
            @Nonnull Node name,
            @Nonnull Node binding) {
        if (node.name == name && node.binding == binding) {
            return node;
        }
        return new AssignmentTargetPropertyProperty((PropertyName) name, (AssignmentTargetAssignmentTargetWithDefault) binding);
    }

    @Nonnull
    @Override
    public AssignmentTargetAssignmentTargetWithDefault reduceAssignmentTargetWithDefault(
            @Nonnull AssignmentTargetWithDefault node,
            @Nonnull Node binding,
            @Nonnull Node init) {
        if (node.binding == binding && node.init == init) {
            return node;
        }
        return new AssignmentTargetWithDefault((AssignmentTarget) binding, (Expression) init);
    }

    @Nonnull
    @Override
    public Expression reduceAwaitExpression(
            @Nonnull AwaitExpression node,
            @Nonnull Node expression) {
        if (node.expression == expression) {
            return node;
        }
        return new AwaitExpression((Expression) expression);
    }

    @Nonnull
    @Override
    public Expression reduceBinaryExpression(
            @Nonnull BinaryExpression node,
            @Nonnull Node left,
            @Nonnull Node right) {
        if (node.left == left && node.right == right) {
            return node;
        }
        return new BinaryExpression((Expression) left, node.operator, (Expression) right);
    }

    @Nonnull
    @Override
    public BindingIdentifier reduceBindingIdentifier(@Nonnull BindingIdentifier node) {
        return node;
    }

    @Nonnull
    @Override
    public BindingProperty reduceBindingPropertyIdentifier(
            @Nonnull BindingPropertyIdentifier node,
            @Nonnull Node binding,
            @Nonnull Maybe<Node> init) {
        if (node.binding == binding && maybeRefEquals(node.init, init)) {
            return node;
        }
        return new BindingPropertyIdentifier((BindingIdentifier) binding, init.map(x -> (Expression) x));
    }

    @Nonnull
    @Override
    public BindingProperty reduceBindingPropertyProperty(
            @Nonnull BindingPropertyProperty node,
            @Nonnull Node name,
            @Nonnull Node binding) {
        if (node.name == name && node.binding == binding) {
            return node;
        }
        return new BindingPropertyProperty((PropertyName) name, (BindingBindingWithDefault) binding);
    }

    @Nonnull
    @Override
    public BindingWithDefault reduceBindingWithDefault(
            @Nonnull BindingWithDefault node,
            @Nonnull Node binding,
            @Nonnull Node init) {
        if (node.binding == binding && node.init == init) {
            return node;
        }
        return new BindingWithDefault((Binding) binding, (Expression) init);
    }

    @Nonnull
    @Override
    public Block reduceBlock(
            @Nonnull Block node,
            @Nonnull ImmutableList<Node> statements) {
        if (listRefEquals(node.statements, statements)) {
            return node;
        }
        return new Block(statements.map(x -> (Statement) x));
    }

    @Nonnull
    @Override
    public Statement reduceBlockStatement(
            @Nonnull BlockStatement node,
            @Nonnull Node block) {
        if (node.block == block) {
            return node;
        }
        return new BlockStatement((Block) block);
    }

    @Nonnull
    @Override
    public Statement reduceBreakStatement(@Nonnull BreakStatement node) {
        return node;
    }

    @Nonnull
    @Override
    public Expression reduceCallExpression(
            @Nonnull CallExpression node,
            @Nonnull Node callee,
            @Nonnull ImmutableList<Node> arguments) {
        if (node.callee == callee && listRefEquals(node.arguments, arguments)) {
            return node;
        }
        return new CallExpression((ExpressionSuper) callee, arguments.map(x -> (SpreadElementExpression) x));
    }

    @Nonnull
    @Override
    public CatchClause reduceCatchClause(
            @Nonnull CatchClause node,
            @Nonnull Node binding,
            @Nonnull Node body) {
        if (node.binding == binding && node.body == body) {
            return node;
        }
        return new CatchClause((Binding) binding, (Block) body);
    }

    @Nonnull
    @Override
    public ClassDeclaration reduceClassDeclaration(
            @Nonnull ClassDeclaration node,
            @Nonnull Node name,
            @Nonnull Maybe<Node> _super,
            @Nonnull ImmutableList<Node> elements) {
        if (node.name == name && maybeRefEquals(node._super, _super) && listRefEquals(node.elements, elements)) {
            return node;
        }
        return new ClassDeclaration((BindingIdentifier) name, _super.map(x -> (Expression) x), elements.map(x -> (ClassElement) x));
    }

    @Nonnull
    @Override
    public ClassElement reduceClassElement(
            @Nonnull ClassElement node,
            @Nonnull Node method) {
        if (node.method == method) {
            return node;
        }
        return new ClassElement(node.isStatic, (MethodDefinition) method);
    }

    @Nonnull
    @Override
    public ClassExpression reduceClassExpression(
            @Nonnull ClassExpression node,
            @Nonnull Maybe<Node> name,
            @Nonnull Maybe<Node> _super,
            @Nonnull ImmutableList<Node> elements) {
        if (maybeRefEquals(node.name, name) && maybeRefEquals(node._super, _super) && listRefEquals(node.elements, elements)) {
            return node;
        }
        return new ClassExpression(name.map(x -> (BindingIdentifier) x), _super.map(x -> (Expression) x), elements.map(x -> (ClassElement) x));
    }

    @Nonnull
    @Override
    public Expression reduceCompoundAssignmentExpression(
            @Nonnull CompoundAssignmentExpression node,
            @Nonnull Node binding,
            @Nonnull Node expression) {
        if (node.binding == binding && node.expression == expression) {
            return node;
        }
        return new CompoundAssignmentExpression((SimpleAssignmentTarget) binding, node.operator, (Expression) expression);
    }

    @Nonnull
    @Override
    public SimpleAssignmentTarget reduceComputedMemberAssignmentTarget(
            @Nonnull ComputedMemberAssignmentTarget node,
            @Nonnull Node object,
            @Nonnull Node expression) {
        if (node.object == object && node.expression == expression) {
            return node;
        }
        return new ComputedMemberAssignmentTarget((ExpressionSuper) object, (Expression) expression);
    }

    @Nonnull
    @Override
    public Expression reduceComputedMemberExpression(
            @Nonnull ComputedMemberExpression node,
            @Nonnull Node object,
            @Nonnull Node expression) {
        if (node.object == object && node.expression == expression) {
            return node;
        }
        return new ComputedMemberExpression((ExpressionSuper) object, (Expression) expression);
    }

    @Nonnull
    @Override
    public PropertyName reduceComputedPropertyName(
            @Nonnull ComputedPropertyName node,
            @Nonnull Node expression) {
        if (node.expression == expression) {
            return node;
        }
        return new ComputedPropertyName((Expression) expression);
    }

    @Nonnull
    @Override
    public Expression reduceConditionalExpression(
            @Nonnull ConditionalExpression node,
            @Nonnull Node test,
            @Nonnull Node consequent,
            @Nonnull Node alternate) {
        if (node.test == test && node.consequent == consequent && node.alternate == alternate) {
            return node;
        }
        return new ConditionalExpression((Expression) test, (Expression) consequent, (Expression) alternate);
    }

    @Nonnull
    @Override
    public Statement reduceContinueStatement(@Nonnull ContinueStatement node) {
        return node;
    }

    @Nonnull
    @Override
    public ObjectProperty reduceDataProperty(
            @Nonnull DataProperty node,
            @Nonnull Node name,
            @Nonnull Node expression) {
        if (node.name == name && node.expression == expression) {
            return node;
        }
        return new DataProperty((PropertyName) name, (Expression) expression);
    }

    @Nonnull
    @Override
    public Statement reduceDebuggerStatement(@Nonnull DebuggerStatement node) {
        return node;
    }

    @Nonnull
    @Override
    public Directive reduceDirective(@Nonnull Directive node) {
        return node;
    }

    @Nonnull
    @Override
    public Statement reduceDoWhileStatement(
            @Nonnull DoWhileStatement node,
            @Nonnull Node body,
            @Nonnull Node test) {
        if (node.body == body && node.test == test) {
            return node;
        }
        return new DoWhileStatement((Statement) body, (Expression) test);
    }

    @Nonnull
    @Override
    public Statement reduceEmptyStatement(@Nonnull EmptyStatement node) {
        return node;
    }

    @Nonnull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExport(
            @Nonnull Export node,
            @Nonnull Node declaration) {
        if (node.declaration == declaration) {
            return node;
        }
        return new Export((FunctionDeclarationClassDeclarationVariableDeclaration) declaration);
    }

    @Nonnull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExportAllFrom(@Nonnull ExportAllFrom node) {
        return node;
    }

    @Nonnull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExportDefault(
            @Nonnull ExportDefault node,
            @Nonnull Node body) {
        if (node.body == body) {
            return node;
        }
        return new ExportDefault((FunctionDeclarationClassDeclarationExpression) body);
    }

    @Nonnull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExportFrom(
            @Nonnull ExportFrom node,
            @Nonnull ImmutableList<Node> namedExports) {
        if (listRefEquals(node.namedExports, namedExports)) {
            return node;
        }
        return new ExportFrom(namedExports.map(x -> (ExportFromSpecifier) x), node.moduleSpecifier);
    }

    @Nonnull
    @Override
    public ExportFromSpecifier reduceExportFromSpecifier(@Nonnull ExportFromSpecifier node) {
        return node;
    }

    @Nonnull
    @Override
    public ExportLocalSpecifier reduceExportLocalSpecifier(
            @Nonnull ExportLocalSpecifier node,
            @Nonnull Node name) {
        if (node.name == name) {
            return node;
        }
        return new ExportLocalSpecifier((IdentifierExpression) name, node.exportedName);
    }

    @Nonnull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceExportLocals(
            @Nonnull ExportLocals node,
            @Nonnull ImmutableList<Node> namedExports) {
        if (listRefEquals(node.namedExports, namedExports)) {
            return node;
        }
        return new ExportLocals(namedExports.map(x -> (ExportLocalSpecifier) x));
    }

    @Nonnull
    @Override
    public Statement reduceExpressionStatement(
            @Nonnull ExpressionStatement node,
            @Nonnull Node expression) {
        if (node.expression == expression) {
            return node;
        }
        return new ExpressionStatement((Expression) expression);
    }

    @Nonnull
    @Override
    public Statement reduceForInStatement(
            @Nonnull ForInStatement node,
            @Nonnull Node left,
            @Nonnull Node right,
            @Nonnull Node body) {
        if (node.left == left && node.right == right && node.body == body) {
            return node;
        }
        return new ForInStatement((VariableDeclarationAssignmentTarget) left, (Expression) right, (Statement) body);
    }

    @Nonnull
    @Override
    public Statement reduceForOfStatement(
            @Nonnull ForOfStatement node,
            @Nonnull Node left,
            @Nonnull Node right,
            @Nonnull Node body) {
        if (node.left == left && node.right == right && node.body == body) {
            return node;
        }
        return new ForOfStatement((VariableDeclarationAssignmentTarget) left, (Expression) right, (Statement) body);
    }

    @Nonnull
    @Override
    public Statement reduceForStatement(
            @Nonnull ForStatement node,
            @Nonnull Maybe<Node> init,
            @Nonnull Maybe<Node> test,
            @Nonnull Maybe<Node> update,
            @Nonnull Node body) {
        if (maybeRefEquals(node.init, init) && maybeRefEquals(node.test, test) && maybeRefEquals(node.update, update) && node.body == body) {
            return node;
        }
        return new ForStatement(init.map(x -> (VariableDeclarationExpression) x), test.map(x -> (Expression) x), update.map(x -> (Expression) x), (Statement) body);
    }

    @Nonnull
    @Override
    public FormalParameters reduceFormalParameters(
            @Nonnull FormalParameters node,
            @Nonnull ImmutableList<Node> items,
            @Nonnull Maybe<Node> rest) {
        if (listRefEquals(node.items, items) && maybeRefEquals(node.rest, rest)) {
            return node;
        }
        return new FormalParameters(items.map(x -> (Parameter) x), rest.map(x -> (Binding) x));
    }

    @Nonnull
    @Override
    public FunctionBody reduceFunctionBody(
            @Nonnull FunctionBody node,
            @Nonnull ImmutableList<Node> directives,
            @Nonnull ImmutableList<Node> statements) {
        if (listRefEquals(node.directives, directives) && listRefEquals(node.statements, statements)) {
            return node;
        }
        return new FunctionBody(directives.map(x -> (Directive) x), statements.map(x -> (Statement) x));
    }

    @Nonnull
    @Override
    public FunctionDeclaration reduceFunctionDeclaration(
            @Nonnull FunctionDeclaration node,
            @Nonnull Node name,
            @Nonnull Node params,
            @Nonnull Node body) {
        if (node.name == name && node.params == params && node.body == body) {
            return node;
        }
        return new FunctionDeclaration(node.isAsync, node.isGenerator, (BindingIdentifier) name, (FormalParameters) params, (FunctionBody) body);
    }

    @Nonnull
    @Override
    public FunctionExpression reduceFunctionExpression(
            @Nonnull FunctionExpression node,
            @Nonnull Maybe<Node> name,
            @Nonnull Node params,
            @Nonnull Node body) {
        if (maybeRefEquals(node.name, name) && node.params == params && node.body == body) {
            return node;
        }
        return new FunctionExpression(node.isAsync, node.isGenerator, name.map(x -> (BindingIdentifier) x), (FormalParameters) params, (FunctionBody) body);
    }

    @Nonnull
    @Override
    public MethodDefinition reduceGetter(
            @Nonnull Getter node,
            @Nonnull Node name,
            @Nonnull Node body) {
        if (node.name == name && node.body == body) {
            return node;
        }
        return new Getter((PropertyName) name, (FunctionBody) body);
    }

    @Nonnull
    @Override
    public IdentifierExpression reduceIdentifierExpression(@Nonnull IdentifierExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public Statement reduceIfStatement(
            @Nonnull IfStatement node,
            @Nonnull Node test,
            @Nonnull Node consequent,
            @Nonnull Maybe<Node> alternate) {
        if (node.test == test && node.consequent == consequent && maybeRefEquals(node.alternate, alternate)) {
            return node;
        }
        return new IfStatement((Expression) test, (Statement) consequent, alternate.map(x -> (Statement) x));
    }

    @Nonnull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceImport(
            @Nonnull Import node,
            @Nonnull Maybe<Node> defaultBinding,
            @Nonnull ImmutableList<Node> namedImports) {
        if (maybeRefEquals(node.defaultBinding, defaultBinding) && listRefEquals(node.namedImports, namedImports)) {
            return node;
        }
        return new Import(defaultBinding.map(x -> (BindingIdentifier) x), namedImports.map(x -> (ImportSpecifier) x), node.moduleSpecifier);
    }

    @Nonnull
    @Override
    public ImportDeclarationExportDeclarationStatement reduceImportNamespace(
            @Nonnull ImportNamespace node,
            @Nonnull Maybe<Node> defaultBinding,
            @Nonnull Node namespaceBinding) {
        if (maybeRefEquals(node.defaultBinding, defaultBinding) && node.namespaceBinding == namespaceBinding) {
            return node;
        }
        return new ImportNamespace(defaultBinding.map(x -> (BindingIdentifier) x), (BindingIdentifier) namespaceBinding, node.moduleSpecifier);
    }

    @Nonnull
    @Override
    public ImportSpecifier reduceImportSpecifier(
            @Nonnull ImportSpecifier node,
            @Nonnull Node binding) {
        if (node.binding == binding) {
            return node;
        }
        return new ImportSpecifier(node.name, (BindingIdentifier) binding);
    }

    @Nonnull
    @Override
    public Statement reduceLabeledStatement(
            @Nonnull LabeledStatement node,
            @Nonnull Node body) {
        if (node.body == body) {
            return node;
        }
        return new LabeledStatement(node.label, (Statement) body);
    }

    @Nonnull
    @Override
    public Expression reduceLiteralBooleanExpression(@Nonnull LiteralBooleanExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public Expression reduceLiteralInfinityExpression(@Nonnull LiteralInfinityExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public Expression reduceLiteralNullExpression(@Nonnull LiteralNullExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public Expression reduceLiteralNumericExpression(@Nonnull LiteralNumericExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public Expression reduceLiteralRegExpExpression(@Nonnull LiteralRegExpExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public Expression reduceLiteralStringExpression(@Nonnull LiteralStringExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public MethodDefinition reduceMethod(
            @Nonnull Method node,
            @Nonnull Node name,
            @Nonnull Node params,
            @Nonnull Node body) {
        if (node.name == name && node.params == params && node.body == body) {
            return node;
        }
        return new Method(node.isAsync, node.isGenerator, (PropertyName) name, (FormalParameters) params, (FunctionBody) body);
    }

    @Nonnull
    @Override
    public Program reduceModule(
            @Nonnull Module node,
            @Nonnull ImmutableList<Node> directives,
            @Nonnull ImmutableList<Node> items) {
        if (listRefEquals(node.directives, directives) && listRefEquals(node.items, items)) {
            return node;
        }
        return new Module(directives.map(x -> (Directive) x), items.map(x -> (ImportDeclarationExportDeclarationStatement) x));
    }

    @Nonnull
    @Override
    public Expression reduceNewExpression(
            @Nonnull NewExpression node,
            @Nonnull Node callee,
            @Nonnull ImmutableList<Node> arguments) {
        if (node.callee == callee && listRefEquals(node.arguments, arguments)) {
            return node;
        }
        return new NewExpression((Expression) callee, arguments.map(x -> (SpreadElementExpression) x));
    }

    @Nonnull
    @Override
    public Expression reduceNewTargetExpression(@Nonnull NewTargetExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public AssignmentTarget reduceObjectAssignmentTarget(
            @Nonnull ObjectAssignmentTarget node,
            @Nonnull ImmutableList<Node> properties) {
        if (listRefEquals(node.properties, properties)) {
            return node;
        }
        return new ObjectAssignmentTarget(properties.map(x -> (AssignmentTargetProperty) x));
    }

    @Nonnull
    @Override
    public Binding reduceObjectBinding(
            @Nonnull ObjectBinding node,
            @Nonnull ImmutableList<Node> properties) {
        if (listRefEquals(node.properties, properties)) {
            return node;
        }
        return new ObjectBinding(properties.map(x -> (BindingProperty) x));
    }

    @Nonnull
    @Override
    public Expression reduceObjectExpression(
            @Nonnull ObjectExpression node,
            @Nonnull ImmutableList<Node> properties) {
        if (listRefEquals(node.properties, properties)) {
            return node;
        }
        return new ObjectExpression(properties.map(x -> (ObjectProperty) x));
    }

    @Nonnull
    @Override
    public Statement reduceReturnStatement(
            @Nonnull ReturnStatement node,
            @Nonnull Maybe<Node> expression) {
        if (maybeRefEquals(node.expression, expression)) {
            return node;
        }
        return new ReturnStatement(expression.map(x -> (Expression) x));
    }

    @Nonnull
    @Override
    public Program reduceScript(
            @Nonnull Script node,
            @Nonnull ImmutableList<Node> directives,
            @Nonnull ImmutableList<Node> statements) {
        if (listRefEquals(node.directives, directives) && listRefEquals(node.statements, statements)) {
            return node;
        }
        return new Script(directives.map(x -> (Directive) x), statements.map(x -> (Statement) x));
    }

    @Nonnull
    @Override
    public MethodDefinition reduceSetter(
            @Nonnull Setter node,
            @Nonnull Node name,
            @Nonnull Node param,
            @Nonnull Node body) {
        if (node.name == name && node.param == param && node.body == body) {
            return node;
        }
        return new Setter((PropertyName) name, (Parameter) param, (FunctionBody) body);
    }

    @Nonnull
    @Override
    public ObjectProperty reduceShorthandProperty(
            @Nonnull ShorthandProperty node,
            @Nonnull Node name) {
        if (node.name == name) {
            return node;
        }
        return new ShorthandProperty((IdentifierExpression) name);
    }

    @Nonnull
    @Override
    public SpreadElementExpression reduceSpreadElement(
            @Nonnull SpreadElement node,
            @Nonnull Node expression) {
        if (node.expression == expression) {
            return node;
        }
        return new SpreadElement((Expression) expression);
    }

    @Nonnull
    @Override
    public SimpleAssignmentTarget reduceStaticMemberAssignmentTarget(
            @Nonnull StaticMemberAssignmentTarget node,
            @Nonnull Node object) {
        if (node.object == object) {
            return node;
        }
        return new StaticMemberAssignmentTarget((ExpressionSuper) object, node.property);
    }

    @Nonnull
    @Override
    public Expression reduceStaticMemberExpression(
            @Nonnull StaticMemberExpression node,
            @Nonnull Node object) {
        if (node.object == object) {
            return node;
        }
        return new StaticMemberExpression((ExpressionSuper) object, node.property);
    }

    @Nonnull
    @Override
    public PropertyName reduceStaticPropertyName(@Nonnull StaticPropertyName node) {
        return node;
    }

    @Nonnull
    @Override
    public ExpressionSuper reduceSuper(@Nonnull Super node) {
        return node;
    }

    @Nonnull
    @Override
    public SwitchCase reduceSwitchCase(
            @Nonnull SwitchCase node,
            @Nonnull Node test,
            @Nonnull ImmutableList<Node> consequent) {
        if (node.test == test && listRefEquals(node.consequent, consequent)) {
            return node;
        }
        return new SwitchCase((Expression) test, consequent.map(x -> (Statement) x));
    }

    @Nonnull
    @Override
    public SwitchDefault reduceSwitchDefault(
            @Nonnull SwitchDefault node,
            @Nonnull ImmutableList<Node> consequent) {
        if (listRefEquals(node.consequent, consequent)) {
            return node;
        }
        return new SwitchDefault(consequent.map(x -> (Statement) x));
    }

    @Nonnull
    @Override
    public Statement reduceSwitchStatement(
            @Nonnull SwitchStatement node,
            @Nonnull Node discriminant,
            @Nonnull ImmutableList<Node> cases) {
        if (node.discriminant == discriminant && listRefEquals(node.cases, cases)) {
            return node;
        }
        return new SwitchStatement((Expression) discriminant, cases.map(x -> (SwitchCase) x));
    }

    @Nonnull
    @Override
    public Statement reduceSwitchStatementWithDefault(
            @Nonnull SwitchStatementWithDefault node,
            @Nonnull Node discriminant,
            @Nonnull ImmutableList<Node> preDefaultCases,
            @Nonnull Node defaultCase,
            @Nonnull ImmutableList<Node> postDefaultCases) {
        if (node.discriminant == discriminant && listRefEquals(node.preDefaultCases, preDefaultCases) && node.defaultCase == defaultCase && listRefEquals(node.postDefaultCases, postDefaultCases)) {
            return node;
        }
        return new SwitchStatementWithDefault((Expression) discriminant, preDefaultCases.map(x -> (SwitchCase) x), (SwitchDefault) defaultCase, postDefaultCases.map(x -> (SwitchCase) x));
    }

    @Nonnull
    @Override
    public ExpressionTemplateElement reduceTemplateElement(@Nonnull TemplateElement node) {
        return node;
    }

    @Nonnull
    @Override
    public Expression reduceTemplateExpression(
            @Nonnull TemplateExpression node,
            @Nonnull Maybe<Node> tag,
            @Nonnull ImmutableList<Node> elements) {
        if (maybeRefEquals(node.tag, tag) && listRefEquals(node.elements, elements)) {
            return node;
        }
        return new TemplateExpression(tag.map(x -> (Expression) x), elements.map(x -> (ExpressionTemplateElement) x));
    }

    @Nonnull
    @Override
    public Expression reduceThisExpression(@Nonnull ThisExpression node) {
        return node;
    }

    @Nonnull
    @Override
    public Statement reduceThrowStatement(
            @Nonnull ThrowStatement node,
            @Nonnull Node expression) {
        if (node.expression == expression) {
            return node;
        }
        return new ThrowStatement((Expression) expression);
    }

    @Nonnull
    @Override
    public Statement reduceTryCatchStatement(
            @Nonnull TryCatchStatement node,
            @Nonnull Node body,
            @Nonnull Node catchClause) {
        if (node.body == body && node.catchClause == catchClause) {
            return node;
        }
        return new TryCatchStatement((Block) body, (CatchClause) catchClause);
    }

    @Nonnull
    @Override
    public Statement reduceTryFinallyStatement(
            @Nonnull TryFinallyStatement node,
            @Nonnull Node body,
            @Nonnull Maybe<Node> catchClause,
            @Nonnull Node finalizer) {
        if (node.body == body && maybeRefEquals(node.catchClause, catchClause) && node.finalizer == finalizer) {
            return node;
        }
        return new TryFinallyStatement((Block) body, catchClause.map(x -> (CatchClause) x), (Block) finalizer);
    }

    @Nonnull
    @Override
    public Expression reduceUnaryExpression(
            @Nonnull UnaryExpression node,
            @Nonnull Node operand) {
        if (node.operand == operand) {
            return node;
        }
        return new UnaryExpression(node.operator, (Expression) operand);
    }

    @Nonnull
    @Override
    public Expression reduceUpdateExpression(
            @Nonnull UpdateExpression node,
            @Nonnull Node operand) {
        if (node.operand == operand) {
            return node;
        }
        return new UpdateExpression(node.isPrefix, node.operator, (SimpleAssignmentTarget) operand);
    }

    @Nonnull
    @Override
    public VariableDeclaration reduceVariableDeclaration(
            @Nonnull VariableDeclaration node,
            @Nonnull ImmutableList<Node> declarators) {
        if (listRefEquals(node.declarators, declarators)) {
            return node;
        }
        return new VariableDeclaration(node.kind, declarators.map(x -> (VariableDeclarator) x));
    }

    @Nonnull
    @Override
    public Statement reduceVariableDeclarationStatement(
            @Nonnull VariableDeclarationStatement node,
            @Nonnull Node declaration) {
        if (node.declaration == declaration) {
            return node;
        }
        return new VariableDeclarationStatement((VariableDeclaration) declaration);
    }

    @Nonnull
    @Override
    public VariableDeclarator reduceVariableDeclarator(
            @Nonnull VariableDeclarator node,
            @Nonnull Node binding,
            @Nonnull Maybe<Node> init) {
        if (node.binding == binding && maybeRefEquals(node.init, init)) {
            return node;
        }
        return new VariableDeclarator((Binding) binding, init.map(x -> (Expression) x));
    }

    @Nonnull
    @Override
    public Statement reduceWhileStatement(
            @Nonnull WhileStatement node,
            @Nonnull Node test,
            @Nonnull Node body) {
        if (node.test == test && node.body == body) {
            return node;
        }
        return new WhileStatement((Expression) test, (Statement) body);
    }

    @Nonnull
    @Override
    public Statement reduceWithStatement(
            @Nonnull WithStatement node,
            @Nonnull Node object,
            @Nonnull Node body) {
        if (node.object == object && node.body == body) {
            return node;
        }
        return new WithStatement((Expression) object, (Statement) body);
    }

    @Nonnull
    @Override
    public Expression reduceYieldExpression(
            @Nonnull YieldExpression node,
            @Nonnull Maybe<Node> expression) {
        if (maybeRefEquals(node.expression, expression)) {
            return node;
        }
        return new YieldExpression(expression.map(x -> (Expression) x));
    }

    @Nonnull
    @Override
    public Expression reduceYieldGeneratorExpression(
            @Nonnull YieldGeneratorExpression node,
            @Nonnull Node expression) {
        if (node.expression == expression) {
            return node;
        }
        return new YieldGeneratorExpression((Expression) expression);
    }
}
